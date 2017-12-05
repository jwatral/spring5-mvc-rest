package com.example.spring5mvcrest.services

import com.example.spring5mvcrest.api.v1.model.CategoryDto
import com.example.spring5mvcrest.domain.Category
import com.example.spring5mvcrest.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(val categoryRepository: CategoryRepository) : CategoryService {
    override fun getAllCategories(): List<CategoryDto> {
        return categoryRepository.findAll().map(Category::toDto)
    }

    override fun getCategoryByName(name: String): CategoryDto? {
        return categoryRepository.findByName(name)?.toDto()
    }
}

fun Category.toDto(): CategoryDto {
    return CategoryDto().apply { name = this@toDto.name }
}