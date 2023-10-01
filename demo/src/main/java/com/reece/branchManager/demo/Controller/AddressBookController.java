package com.reece.branchManager.demo.Controller;

import com.reece.branchManager.demo.Entity.AddressBook;
import com.reece.branchManager.demo.Entity.Contact;
import com.reece.branchManager.demo.Repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/address-books")
public class AddressBookController {
    private final AddressBookRepository addressBookRepository;

    @Autowired
    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    public static boolean isValidNumberString(String str, int length) {
        // Ensure the string is not null and matches the pattern
        if (str != null && str.matches("\\d+") && str.length() == length) {
            return true;
        }
        return false;
    }

    // Add a new address book
    @PostMapping
    public ResponseEntity<String> addAddressBook(@RequestBody AddressBook addressBook) {
        String phoneNumber= addressBook.getPhoneNumber();
        if(isValidNumberString(phoneNumber,10))
        {
             addressBookRepository.save(addressBook);
             return ResponseEntity.ok("User created successfully");
        }
        else
            return ResponseEntity.badRequest().body("Invalid phone number");
    }



    // List all address books
    @GetMapping
    public List<AddressBook> listAddressBooks() {
        return addressBookRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void removeContact(@PathVariable Long id) {
        addressBookRepository.deleteById(id);
    }

    // Print a unique set of all contacts across multiple address books
    @GetMapping("/{id}/contacts")
    public Optional<Contact> getAllContactsInAddressBook(@PathVariable Long id) {
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        return addressBook.map(AddressBook::getContacts);
    }
}