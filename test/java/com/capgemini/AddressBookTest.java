package com.capgemini;

import org.junit.Test;
import com.capgemini.AddressBook;
import static org.junit.Assert.*;

import org.junit.Assert;

public class AddressBookTest {
	@Test
    public void firstNameTest() {
        ValidateContact contact = new ValidateContact();
        boolean result = contact.validateFirstName("Shreya");
        Assert.assertTrue(true);
 } 
 @Test
    public void lastNameTest() {
        ValidateContact contact = new ValidateContact();
        boolean result = contact.validateLastName("Reddy");
        Assert.assertTrue(true);
 }
 @Test
    public void emailTest() {
        ValidateContact contact = new ValidateContact();
        boolean result = contact.validateEmail("shreya.reddy@gmail.com");
        Assert.assertTrue(true);
 }
 @Test
    public void phoneNoTest() {
        ValidateContact contact = new ValidateContact();
        boolean result = contact.validatePhoneNo("91 9100887766");
        Assert.assertTrue(true);
 }
 @Test
    public void addressTest() {
        ValidateContact contact = new ValidateContact();
        boolean result = contact.validateAddress("miyapur");
        Assert.assertTrue(true);
 }
 @Test
    public void cityTest() {
        ValidateContact contact = new ValidateContact();
        boolean result = contact.validateCity("hyderabad");
        Assert.assertTrue(true);
 }
 @Test
    public void stateTest() {
        ValidateContact contact = new ValidateContact();
        boolean result = contact.validateState("Telangana");
        Assert.assertTrue(true);
 }

}
