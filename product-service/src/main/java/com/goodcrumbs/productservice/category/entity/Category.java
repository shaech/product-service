package com.goodcrumbs.productservice.category.entity;

//v1 - Category POJO

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Category {
    private String id;    //later -UUID
    private String name;
    private String description;
    private boolean active;
}
