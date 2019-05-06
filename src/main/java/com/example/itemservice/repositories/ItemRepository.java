package com.example.itemservice.repositories;

import com.example.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User: edward <br/>
 * Date: 5/5/19 4:20 PM <br/>
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long > {

    Optional<Item> findByName(String itemName);

}
