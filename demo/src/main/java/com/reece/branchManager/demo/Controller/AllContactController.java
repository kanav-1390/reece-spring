package com.reece.branchManager.demo.Controller;

import com.reece.branchManager.demo.Entity.Contact;
import com.reece.branchManager.demo.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contacts/all")
public class AllContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContactsAcrossAddressBooks();
    }
}
