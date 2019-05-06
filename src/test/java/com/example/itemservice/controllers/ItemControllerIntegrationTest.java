package com.example.itemservice.controllers;

import com.example.itemservice.ItemServiceApplication;
import com.example.itemservice.domain.Item;
import com.example.itemservice.services.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * User: edward <br/>
 * Date: 5/5/19 6:03 PM <br/>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemControllerIntegrationTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private  ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void getAllItems_returns_List_ofItems() throws Exception {


        Item item1 = new Item(null, "Computer", 200);
        Item item2 = new Item(null, "Laptop", 300);

        itemService.saveItem(item1);
        itemService.saveItem(item2);

        List<Item> allItem = itemService.getAllItem();
        String itemsJson = objectMapper.writeValueAsString(allItem);

        mockMvc.perform(MockMvcRequestBuilders.get("/items")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(itemsJson))
                .andReturn();
    }

    @Test
    public void getItemByName_returns_anItem_when_called_with_itemName() throws Exception {


        String itemName = "Computer";
        Item item1 = new Item(null, "Computer", 200);
        Item item2 = new Item(null, "Laptop", 300);

        itemService.saveItem(item1);
        itemService.saveItem(item2);

        Item item = itemService.getByName(itemName);
        String itemsJson = objectMapper.writeValueAsString(item);

        mockMvc.perform(MockMvcRequestBuilders.get("/items/"+itemName)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(itemsJson))
                .andReturn();
    }

}
















