package com.goodcrumbs.productservice.category.mapper;

import com.goodcrumbs.productservice.category.dto.CategoryRequestDto;
import com.goodcrumbs.productservice.category.dto.CategoryResponseDto;
import com.goodcrumbs.productservice.category.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryRequestDto requestdto){
        return Category.builder()
        .name(requestdto.getName())
        .description(requestdto.getDescription())
        .build();
    }

    public CategoryResponseDto toResponseDto(Category category){
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .active(category.isActive())
                .build();
    }
}
