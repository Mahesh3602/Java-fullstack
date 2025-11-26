package com.sight.ecommerce.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sight.ecommerce.dto.ProductDto;
import com.sight.ecommerce.model.Category;
import com.sight.ecommerce.model.Product;
import com.sight.ecommerce.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

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


    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for(Product product : products) {
            productDtos.add(new ProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(Integer productID, ProductDto productDto, Category category) {
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());

        product.setId(productID);
        productRepository.save(product);
    }

}
