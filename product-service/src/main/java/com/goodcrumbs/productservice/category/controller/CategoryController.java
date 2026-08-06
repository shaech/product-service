package com.goodcrumbs.productservice.category.controller;

import com.goodcrumbs.productservice.category.dto.CategoryRequestDto;
import com.goodcrumbs.productservice.category.dto.CategoryResponseDto;
import com.goodcrumbs.productservice.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;   //constructor dependency injection - Bcz of this, @RequiredArgsConstructor -Lombok generates a constructor for all final fields, enabling constructor dependency injection.

    /* Creates a new Category */
    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory( @Valid @RequestBody CategoryRequestDto categoryRequestDto){

         CategoryResponseDto createCategoryResponse = categoryService.createCategory(categoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategoryResponse);
    }

    /* Get a list of all categories*/
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(){
        List<CategoryResponseDto> getAllCategoriesResponse = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(getAllCategoriesResponse);
    }

    /*Get category by id*/
    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDto> getCategoriesById(@RequestParam String id){
        CategoryResponseDto catByIdResponse = categoryService.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(catByIdResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable String id, @RequestBody CategoryRequestDto categoryToUpdate){
        CategoryResponseDto updateCategoryResp = categoryService.updateCategory(id, categoryToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(updateCategoryResp);
    }

    @DeleteMapping("{id}")
    public String deleteCategory(@PathVariable String id){
        categoryService.deleteCategory(id);
        return HttpStatus.OK.toString();
    }

    @PatchMapping("id")
    public ResponseEntity<CategoryResponseDto> updateStatusOfCategory(@RequestParam String id, @RequestParam boolean active){
        CategoryResponseDto updatedStatusResponse = categoryService.updateCategoryStatus(id,active);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedStatusResponse);
    }
}
