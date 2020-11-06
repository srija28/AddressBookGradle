package com.capgemini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AddressBookDBService {
	private static AddressBookDBService abService;
	private PreparedStatement preparedStatement;
	public static AddressBookDBService getInstance() {
		if (abService == null) {
			abService = new AddressBookDBService();
		}
		return abService;
	}

	private Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_service?useSSL=false";
		String userName = "root";
		String password = "Shreya@57";
		Connection connection;
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		return connection;
	}

	public List<AddressBookData> readData() {
		String sql = "select * from addressbook;";
		List<AddressBookData> employeePayrollList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			employeePayrollList = this.getAddressBookData(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	private List<AddressBookData> getAddressBookData(ResultSet result) {
		List<AddressBookData> addressBookList = new ArrayList<>();
		try {
			while (result.next()) {
				
				String fname = result.getString("firstname");
				String lname = result.getString("last_name");
				String address = result.getString("address");
				String city = result.getString("city");
				String state = result.getString("state");
				String zip = result.getString("zip");
				String phone_no = result.getString("phone");
				String email = result.getString("email");
				addressBookList.add(new AddressBookData(fname, lname, address, city, state, zip, phone_no, email));
			}
			System.out.println(addressBookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressBookList;
	}
	
	public int updateAddressBookData_Using_PreparedStatement(String fname, String city) {
		return this.updateAddressBookDataUsingPreparedStatement(fname, city);
	}

	private int updateAddressBookDataUsingPreparedStatement(String fname, String city) {
		String sql = String.format("update addressbook set city= '%s' where firstname = '%s';", city, fname);
		try (Connection connection = this.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(sql);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Map<String, Integer> getCountByCity() {
 		String sql = "SELECT city, COUNT(city) AS count_city FROM addressbook GROUP BY city";
 		Map<String, Integer> cityToContactsMap = new HashMap<>();
 		try(Connection connection = this.getConnection()) {
 			Statement statement = connection.createStatement();
 			ResultSet result = statement.executeQuery(sql);
 			while(result.next()) {
 				String city = result.getString("city");
 				int count = result.getInt("count_city");
 				cityToContactsMap.put(city, count);
 			}
 		}
 		catch(SQLException e) {
 			e.printStackTrace();
 		}
 		return cityToContactsMap;
 	}

	public int getContactsOnDateRange(LocalDate startDate, LocalDate endDate) throws AddressBookDBException{
		
		String sql = String.format("SELECT firstname FROM addressbook WHERE start BETWEEN '%s' AND '%s';",
				Date.valueOf(startDate), Date.valueOf(endDate));
		int noOfContacts = 0;
		try (Connection connection = getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				noOfContacts++;
			}
		} catch (SQLException e) {
			throw new AddressBookDBException(AddressBookDBException.ExceptionType.CONNECTION_ERROR, e.getMessage());
		}
		return noOfContacts;
	}	
}