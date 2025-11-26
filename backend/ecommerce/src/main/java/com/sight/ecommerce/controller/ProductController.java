package com.sight.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sight.ecommerce.dto.ProductDto;
import com.sight.ecommerce.models.Category;
import com.sight.ecommerce.service.CategoryService;
import com.sight.ecommerce.service.ProductService;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/product")
public class ProductController {
   
    @Autowired
    private ProductService productService;  

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        //TODO: process POST request
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        com.sight.ecommerce.models.Category category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
