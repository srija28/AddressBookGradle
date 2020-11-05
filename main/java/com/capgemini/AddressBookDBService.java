package com.capgemini;

import java.sql.Connection;
import java.sql.DriverManager;
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

 	public Map<String, Integer> getCountByState() {
 		String sql = "SELECT state, COUNT(state) AS count_state FROM addressbook GROUP BY state";
 		Map<String, Integer> stateToContactsMap = new HashMap<>();
 		try(Connection connection = this.getConnection()) {
 			Statement statement = connection.createStatement();
 			ResultSet result = statement.executeQuery(sql);
 			while(result.next()) {
 				String state = result.getString("state");
 				int count = result.getInt("count_state");
 				stateToContactsMap.put(state, count);
 			}
 		}
 		catch(SQLException e) {
 			e.printStackTrace();
 		}
 		return stateToContactsMap;
 	}
 	public AddressBookData addContact(String firstname, String last_name, String address, String city, String state,
 			String zipcode, String phone, String email) {
 		AddressBookData addBookData = null;
 		String sql = String.format("INSERT INTO addressbook(firstname, last_name, address, city, state, zip, phone,email) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", firstname, last_name, address, city, state, zipcode, phone, email);
 		try(Connection connection = this.getConnection()) {
 			Statement statement = connection.createStatement();
 			int rowAffected = statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS);
 			if(rowAffected == 1) {
 				ResultSet result = statement.getGeneratedKeys();
 				if(result.next()) {

 					String fname = result.getString("firstname");
 					String lname = result.getString("last_name");
 					String address1 = result.getString("address");
 					String city1 = result.getString("city");
 					String state1 = result.getString("state");
 					String zip = result.getString("zip");
 					String phoneno = result.getString("phone");
 					String email1 = result.getString("email");
 					addBookData = new AddressBookData(fname, lname, address1, city1, state1, zip, phoneno, email1);
 				}
 			}

 		}
 		catch(SQLException e) {
 			e.printStackTrace();
 		}
 		return addBookData;


 	}
}