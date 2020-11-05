package com.capgemini;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

import com.capgemini.AddressBookData;
import com.capgemini.AddressBookService;
import com.capgemini.AddressBookService.IOService;

public class AddressBookDBTest {

	private AddressBookDBService addressBookDBService;

	@Before
	public void initialize() {
		addressBookDBService = new AddressBookDBService();
	}

	
	@Test 
    public void givenNewCity_WhenUpdated_shouldMatchWithDB() {
    	AddressBookService service = new AddressBookService();
    	service.readAddressBookData(IOService.DB_IO);
    	service.updateContactsCity("shreya", "cen");
    	boolean result = service.checkAddressBookDataInSyncWithDB("shreya","cen");
		Assert.assertTrue(result);
    }
	@Test
 	public void givenContactsData_WhenCountByState_ShouldReturnProperValue() {
 		AddressBookService service = new AddressBookService();
 		service.readAddressBookData(IOService.DB_IO);
 		Map<String, Integer> countContactsByState = service.readCountContactsByState(IOService.DB_IO);
 		Assert.assertTrue(countContactsByState.get("ap").equals(1));
 	}
	
	@Test
 	public void givenNewContact_WhenAdded_ShouldSyncWithDB() {
 		AddressBookService service = new AddressBookService();
 		service.readAddressBookData(IOService.DB_IO);
 		service.addContact("ssss", "ghi", "county", "hyd", "telangana", "5000049", "839748392", "sssss@gmail.com");
 		boolean result = service.checkAddressBookDataInSyncWithDB("ssss", "hyd");
 		Assert.assertTrue(result);
 	}

	
}