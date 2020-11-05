package com.capgemini;

import java.util.List;
import java.util.Map;

public class AddressBookService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	private static List<AddressBookData> addList;
	private AddressBookDBService addressBookDBService;

	public AddressBookService() {
		addressBookDBService = AddressBookDBService.getInstance();
	}

	public AddressBookService(List<AddressBookData> empList) {
		this.addList = addList;
	}

	public List<AddressBookData> readAddressBookData(IOService dbIo) {
		if (dbIo.equals(IOService.DB_IO)) {
			this.addList = new AddressBookDBService().readData();
		}
		return this.addList;
	}
	private AddressBookData getAddressBookData(String name) {
		for (AddressBookData data : addList) {
			if (data.firstname.equals(name)) {
				return data;
			}
		}
		return null;
	}
	
	public void updateContactsCity(String firstname, String city) {
		int result = addressBookDBService.updateAddressBookData_Using_PreparedStatement(firstname, city);
		if (result == 0)
			return;
		AddressBookData addBookData = this.getAddressBookData(firstname);
		if (addBookData != null)
			addBookData.city = city;
	}

	public boolean checkAddressBookDataInSyncWithDB(String fname, String city) {
		for (AddressBookData data : addList) {
			if (data.firstname.equals(fname)) {
				if (data.city.equals(city)) {
					return true;
				}
			}
		}
		return false;
	}
	public Map<String, Integer> readCountContactsByCity(IOService ioService) {
 		if(ioService.equals(IOService.DB_IO)) {
 			return addressBookDBService.getCountByCity();
 		}
 		return null;
 	}

 	public Map<String, Integer> readCountContactsByState(IOService ioService) {
 		if(ioService.equals(IOService.DB_IO)) {
 			return addressBookDBService.getCountByState();
 		}
 		return null;
 	}
 	
 	public void addContact(String firstname, String last_name, String  address, String city, String state, String zipcode, String phone, String email) {
 		addList.add(addressBookDBService.addContact(firstname, last_name, address, city, state, zipcode, phone, email));
 	}

}