package com.goodcrumbs.productservice.category.service;

import com.goodcrumbs.productservice.category.dto.CategoryRequestDto;
import com.goodcrumbs.productservice.category.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto catRequestDto);
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto getCategoryById(String id);
    CategoryResponseDto updateCategory(String id, CategoryRequestDto catRequestDto);
    void deleteCategory(String id);

    CategoryResponseDto updateCategoryStatus(String id, boolean active);

}
