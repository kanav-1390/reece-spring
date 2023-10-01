package com.reece.branchManager.demo.Repository;

import com.reece.branchManager.demo.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
