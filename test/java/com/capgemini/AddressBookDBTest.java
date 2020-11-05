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


	
}