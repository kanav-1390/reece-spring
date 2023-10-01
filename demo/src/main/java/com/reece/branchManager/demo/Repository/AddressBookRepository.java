package com.reece.branchManager.demo.Repository;

import com.reece.branchManager.demo.Entity.AddressBook;
import com.reece.branchManager.demo.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
}
