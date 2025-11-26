package com.sight.ecommerce.dto;

import javax.validation.constraints.NotNull;

import com.sight.ecommerce.model.Product;

public class ProductDto {
  
    private Integer id;
    private @NotNull String name;
    private @NotNull String description;
    private @NotNull String imageUrl;    
    private @NotNull Double price;
    private @NotNull Integer categoryId;
    
    public ProductDto() {
    }

    public ProductDto(Integer id, @NotNull String name, @NotNull String description, @NotNull String imageUrl,
            @NotNull Double price, @NotNull Integer categoryId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.categoryId = categoryId;
    }

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setDescription(product.getDescription());
        this.setImageUrl(product.getImageUrl());
        this.setPrice(product.getPrice());
        this.setCategoryId(product.getCategory().getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}


