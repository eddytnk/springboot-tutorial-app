package com.example.itemservice.repositories;

import com.example.itemservice.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * User: edward <br/>
 * Date: 5/5/19 4:14 PM <br/>
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void given_itemName_returns_Item(){
        String itemName = "Computer";

        Item item = new Item();
        item.setName("Computer");
        item.setPrice(10000);

        itemRepository.save(item);

        Optional<Item> searchedItem =  itemRepository.findByName(itemName);

        assertThat(searchedItem.get()).isNotNull();
        assertThat(searchedItem.get().getName()).isEqualTo(itemName);

    }
}
