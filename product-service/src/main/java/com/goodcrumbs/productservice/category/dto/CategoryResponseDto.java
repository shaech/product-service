package com.goodcrumbs.productservice.category.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDto {

    private String id;
    private String name;
    private String description;
    private boolean active;
}
