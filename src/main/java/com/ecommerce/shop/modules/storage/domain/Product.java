package com.ecommerce.shop.modules.storage.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "products", schema = "inventory")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "fried_frozen")
    private Boolean isFrozen;

    @Column(name = "expiration_date")
    private LocalDate expiration_date;

    @Column(name = "grams")
    private Integer grams;

    @Column(name = "package_quantity")
    private int packageQuantity;
}
