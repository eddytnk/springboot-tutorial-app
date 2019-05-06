package com.example.itemservice.services;

import com.example.itemservice.exceptions.ResourceNotFoundException;
import com.example.itemservice.domain.Item;
import com.example.itemservice.repositories.ItemRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * User: edward <br/>
 * Date: 5/5/19 4:46 PM <br/>
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository mockItemRepository;

    @InjectMocks
    private ItemService itemService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getAllItem_returns_all_item_in_Database(){

        Item item1 = new Item();
        item1.setId(1L);

        Item item2 = new Item();
        item2.setId(1L);

        List<Item> expectedValue = Arrays.asList(item1, item2);

        when(mockItemRepository.findAll())
                .thenReturn(expectedValue);

        List<Item> items = itemService.getAllItem();
        verify(mockItemRepository).findAll();
        assertThat(items).isNotNull();
        assertThat(items).isEqualToComparingFieldByField(expectedValue);

    }

    @Test
    public void saveItem_returns_a_item(){

        Item item = new Item();
        item.setId(1L);

        when(mockItemRepository.save(item))
                .thenReturn(item);

        Item actualItem = itemService.saveItem(item);
        verify(mockItemRepository).save(item);
        assertThat(actualItem).isEqualToComparingFieldByField(item);

    }

    @Test
    public void getByName_returns_an_item_with_sameName(){
                Item item = new Item(1L, "dell", 800);
                when(mockItemRepository.findByName("dell")).thenReturn(Optional.of(item));

                Item savedItem = itemService.getByName("dell");

                assertThat(savedItem).isEqualToComparingFieldByField(item);
    }

    @Test
    public void getByName_throws_Exception_when_item_does_not_exist(){

        when(mockItemRepository.findByName(anyString()))
                .thenReturn(Optional.empty());

        expectedException.expect(ResourceNotFoundException.class);
        expectedException.expectMessage("Item not found!");

        itemService.getByName("lewis");
    }

}
