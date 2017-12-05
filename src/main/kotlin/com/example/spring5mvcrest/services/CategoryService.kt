package com.example.spring5mvcrest.services

import com.example.spring5mvcrest.api.v1.model.CategoryDto

interface CategoryService {

    fun getAllCategories(): List<CategoryDto>
    fun getCategoryByName(name: String): CategoryDto?

}