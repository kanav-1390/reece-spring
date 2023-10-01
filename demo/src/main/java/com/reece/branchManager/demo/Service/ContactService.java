package com.reece.branchManager.demo.Service;

import com.reece.branchManager.demo.Entity.AddressBook;
import com.reece.branchManager.demo.Entity.Contact;
import com.reece.branchManager.demo.Repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private AddressBookRepository addressBookRepository;

    public List<Contact> getAllContactsAcrossAddressBooks() {
        List<Contact> allContacts = new ArrayList<>();
        List<AddressBook> addressBooks = addressBookRepository.findAll();

        for (AddressBook addressBook : addressBooks) {
            allContacts.add(addressBook.getContacts());
        }

        return allContacts.stream().distinct().collect(Collectors.toList());
    }
}

