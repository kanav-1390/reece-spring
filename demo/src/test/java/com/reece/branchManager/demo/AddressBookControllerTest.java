package com.reece.branchManager.demo;

import com.reece.branchManager.demo.Controller.AddressBookController;
import com.reece.branchManager.demo.Controller.ContactController;
import com.reece.branchManager.demo.Entity.AddressBook;
import com.reece.branchManager.demo.Entity.Contact;
import com.reece.branchManager.demo.Repository.AddressBookRepository;
import com.reece.branchManager.demo.Repository.ContactRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressBookController.class)
public class AddressBookControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactRepository contactRepository;

    @Autowired
    private AddressBookRepository addressBookRepository;

    @MockBean
    private AddressBookRepository userRepository;


    @Test
    public void testPostAddress() throws Exception {

        String entityJson = "{\"name\":\"TestEntity\", \"phoneNumber\":\"1234567890\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/address-books")
                        .contentType(MediaType.APPLICATION_JSON).content(entityJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAddress() throws Exception {
        AddressBook user1 = new AddressBook();
        AddressBook user2 = new AddressBook();
        user1.setId(1L);
        user1.setName("testUser1");
        user1.setPhoneNumber("1234567890");
        user1.setContacts(null);
        user2.setId(2L);
        user2.setContacts(null);
        user2.setName("testUser2");
        user2.setPhoneNumber("0987654321");
        List<AddressBook> list = Arrays.asList(user1,user2);
        when(userRepository.findAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/address-books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("testUser1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber").value("1234567890"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("testUser2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].phoneNumber").value("0987654321"))
        ;

    }
    @Test
    public void testDeleteContact() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/address-books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPhoneNumber() throws Exception{
        Assertions.assertEquals(AddressBookController.isValidNumberString("1234567890",10),true);
    }


}
