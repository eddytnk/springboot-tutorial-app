package com.example.itemservice.services;

import com.example.itemservice.exceptions.ResourceNotFoundException;
import com.example.itemservice.domain.Item;
import com.example.itemservice.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User: edward <br/>
 * Date: 5/5/19 4:53 PM <br/>
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }


    public Item getByName(String itemName) {
        Optional<Item> itemOptional = itemRepository.findByName(itemName);
        if(!itemOptional.isPresent())
            throw new ResourceNotFoundException("Item not found!");
        return itemOptional.get();
    }

    public Item saveItem(Item item){
        return  itemRepository.save(item);
    }
}
