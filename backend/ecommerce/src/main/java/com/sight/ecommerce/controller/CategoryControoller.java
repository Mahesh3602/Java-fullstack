package com.sight.ecommerce.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sight.ecommerce.models.Category;
import com.sight.ecommerce.service.CategoryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/category")
public class CategoryControoller {
   @Autowired
   private CategoryService categoryService;

   @GetMapping("/")
   public ResponseEntity<List<Category>> getCategories() {
       List<Category> body = categoryService.listCategories();
       return new ResponseEntity<List<Category>>(body, HttpStatus.OK);
   }
   

   @PostMapping("/")
   public ResponseEntity<Void> createCategory(@RequestBody Category category) {
      
       if(Objects.nonNull(categoryService.readCategory(category.getCategoryName()))){
              return new ResponseEntity<Void>(HttpStatus.CONFLICT); // Conflict
       }
         categoryService.createCategory(category);

       return new ResponseEntity<Void>(HttpStatus.CREATED);
   }
   
   @PostMapping("/{categoryID}")
   public ResponseEntity<Void> updateCategory(@PathVariable("categoryID") Integer categoryID,@RequestBody Category category) {
         if (Objects.nonNull(categoryService.readCategory(categoryID))) {
            categoryService.updateCategory(categoryID, category);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
         }
    
       return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
       
   }
   
}
