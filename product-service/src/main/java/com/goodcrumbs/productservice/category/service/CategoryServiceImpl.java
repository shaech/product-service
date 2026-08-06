package com.goodcrumbs.productservice.category.service;

import com.goodcrumbs.productservice.category.dto.CategoryRequestDto;
import com.goodcrumbs.productservice.category.dto.CategoryResponseDto;
import com.goodcrumbs.productservice.category.entity.Category;
import com.goodcrumbs.productservice.category.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryMapper categoryMapper;
    private final Map<String, Category> categoryStore = new HashMap<>();

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto catRequestDto) {
        Category category = categoryMapper.toEntity(catRequestDto);
        category.setId(UUID.randomUUID().toString());
        category.setActive(false);
        categoryStore.put(category.getId(),category);

        CategoryResponseDto categoryResponseDto = categoryMapper.toResponseDto(category);

        return categoryResponseDto;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryStore.values()
                .stream()
                .map(categoryMapper::toResponseDto)
                .toList();
    }

    @Override
    public CategoryResponseDto getCategoryById(String id) {
        Category category = categoryStore.get(id);
        if(category == null){
            throw new RuntimeException("Category Not Found.");
        }
        return categoryMapper.toResponseDto(category);
    }

    @Override
    public CategoryResponseDto updateCategory(String id, CategoryRequestDto catRequestDto) {
        //Category category = categoryMapper.toEntity(catRequestDto);    //cons - risk of losing ID and active. prone to issues.  // Don't recreate entity. Preserve immutable/business-managed fields.
        Category category = categoryStore.get(id);   //now we know exactly which Id to change.

        if(category == null) {
            throw new RuntimeException("Category not found");}

        category.setName(catRequestDto.getName());
        category.setDescription(catRequestDto.getDescription());

        categoryStore.put(id,category);   // not really required. just added for readibility

        return categoryMapper.toResponseDto(category);
    }

    @Override
    public void deleteCategory(String id) {

        Category category = categoryStore.get(id);

        if (category == null) {
            throw new RuntimeException("Category not found");
        }
        //only below line would work. but we add above to check null
        categoryStore.remove(id);
    }

    @Override
    public CategoryResponseDto updateCategoryStatus(String id, boolean active){
        Category category = categoryStore.get(id);

        if (category == null) {
            throw new RuntimeException("Category not found");
        }

        category.setActive(active);
        return categoryMapper.toResponseDto(category);
    }
}
