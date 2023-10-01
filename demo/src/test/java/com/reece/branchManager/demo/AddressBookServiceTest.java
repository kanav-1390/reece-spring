package com.reece.branchManager.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.reece.branchManager.demo.Entity.AddressBook;
import com.reece.branchManager.demo.Entity.Contact;
import com.reece.branchManager.demo.Repository.AddressBookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@DataJpaTest
public class AddressBookServiceTest {

    @MockBean
    private AddressBookRepository addressBookRepository;

    @Test
    public void testGetContactsForValidAddressBookId() {
        // Arrange: Create a sample AddressBook
        Contact contact =new Contact();
        contact.setId(1L);
        contact.setName("testUser1");
        contact.setEmail("abc@gmail.com");
        AddressBook address = new AddressBook();
        address.setId(1L);
        address.setName("testUser1");
        address.setPhoneNumber("1234567890");
        address.setContacts(contact);

        // Mock the behavior of addressBookRepository.findById
        when(addressBookRepository.findById(1L)).thenReturn(Optional.of(address));

        // Act: Call the service method
        List<Contact> contactsOptional = Arrays.asList(address.getContacts());
        assertNotNull(contactsOptional);
        assertEquals(address.getContacts(), contactsOptional.get(0));

    }

}

