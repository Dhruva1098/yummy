package com.inventory.Inventory.ProductEntity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Items")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;

    private String item_name;
    private String description;
    private double price;

}
