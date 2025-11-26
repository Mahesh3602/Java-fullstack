package com.sight.ecommerce.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sight.ecommerce.dto.ProductDto;
import com.sight.ecommerce.models.Category;
import com.sight.ecommerce.models.Product;
import com.sight.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
 
    @Autowired
    private ProductRepository productRepository ;

    public void addProduct(ProductDto productDto, Category category) {
        // Logic to create a product
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(category);
        product.setImageUrl(productDto.getImageUrl());

        
        productRepository.save(product);

    }
}
