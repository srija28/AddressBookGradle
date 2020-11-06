package com.capgemini;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;

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
	public void givenAddressBookDB_WhenRetrivedBasedOnDate_ShouldReturnCount() throws AddressBookDBException {
		LocalDate startDate = LocalDate.of(2018, 01, 01);
		LocalDate endDate = LocalDate.now();
		int noOfContacts= addressBookDBService.getContactsOnDateRange(startDate, endDate);
		Assert.assertEquals(3, noOfContacts);
	}
	
}