package com.reece.branchManager.demo;

import com.reece.branchManager.demo.Controller.ContactController;
import com.reece.branchManager.demo.Entity.Contact;
import com.reece.branchManager.demo.Repository.ContactRepository;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ContactController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactRepository userRepository;

    @Test
    public void testPostContact() throws Exception {

        String entityJson = "{\"name\":\"TestEntity\", \"email\":\"abc@gmail.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                        .contentType(MediaType.APPLICATION_JSON).content(entityJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetContact() throws Exception {
        Contact user1 = new Contact();
        Contact user2 = new Contact();
        user1.setId(1L);
        user1.setName("testUser1");
        user1.setEmail("abc@gmail.com");
        user2.setId(2L);
        user2.setName("testUser2");
        user2.setEmail("def@gmail.com");
        List<Contact> list =Arrays.asList(user1,user2);
        when(userRepository.findAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/contacts"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("testUser1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("abc@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("testUser2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("def@gmail.com"))
        ;

    }
    @Test
    public void testDeleteContact() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/contacts/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}

