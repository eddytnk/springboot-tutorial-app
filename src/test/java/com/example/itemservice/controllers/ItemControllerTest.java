package com.example.itemservice.controllers;

import com.example.itemservice.domain.Item;
import com.example.itemservice.services.ItemService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * User: edward <br/>
 * Date: 5/5/19 6:03 PM <br/>
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

    @Mock
    private ItemService mockItemService;

    @InjectMocks
    private ItemController itemController;


    @Test
    public void getAllItems_returns_List_ofItems(){

        when(mockItemService.getAllItem())
                .thenReturn(Lists.newArrayList(new Item(1L, "laptop", 200)));

        List<Item> allItems = itemController.getAllItems();
        verify(mockItemService).getAllItem();
        assertThat(allItems).isNotNull();
        assertThat(allItems.size()).isEqualTo(1);
    }

    @Test
    public void getItemByName_returns_anItem_when_called_with_itemName(){

        String itemName = "Laptop";
        Item item = new Item(1L, itemName, 200);
        when(mockItemService.getByName(itemName))
                .thenReturn(item);

        Item anItem = itemController.getItemByName(itemName);
        verify(mockItemService).getByName(itemName);
        assertThat(anItem).isNotNull();
        assertThat(anItem).isEqualToComparingFieldByField(item);
    }
}
