package com.reece.branchManager.demo.Controller;

import com.reece.branchManager.demo.Entity.Contact;
import com.reece.branchManager.demo.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Add a new contact
    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    // Remove an existing contact
    @DeleteMapping("/{id}")
    public void removeContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }

    // List all contacts
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}