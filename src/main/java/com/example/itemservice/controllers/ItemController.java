package com.example.itemservice.controllers;

import com.example.itemservice.domain.Item;
import com.example.itemservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: edward <br/>
 * Date: 5/5/19 6:11 PM <br/>
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping()
    public List<Item> getAllItems() {
        return itemService.getAllItem();
    }
    @GetMapping("/{itemName}")
    public Item getItemByName(@PathVariable String itemName) {
        return itemService.getByName(itemName);
    }
}
