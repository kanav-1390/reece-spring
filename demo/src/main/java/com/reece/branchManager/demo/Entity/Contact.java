package com.reece.branchManager.demo.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Contact")
public class Contact {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    public String name;
    public String email;

    @OneToMany(mappedBy = "contacts")
    public Set<AddressBook> addressBooks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    // getters and setters
}