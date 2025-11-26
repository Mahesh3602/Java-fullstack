package com.sight.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sight.ecommerce.dto.ProductDto;
import com.sight.ecommerce.model.Category;
import com.sight.ecommerce.service.CategoryService;
import com.sight.ecommerce.service.ProductService;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        Category category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> productDtos = productService.listProducts();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @PostMapping("/{productID}")
    public ResponseEntity<Void> updateProduct(@PathVariable("productID") Integer productID,
                                                     @RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.updateProduct(productID, productDto, category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
