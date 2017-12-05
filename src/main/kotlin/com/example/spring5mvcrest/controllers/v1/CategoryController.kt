package com.example.spring5mvcrest.controllers.v1

import com.example.spring5mvcrest.api.v1.model.CategoryListDto
import com.example.spring5mvcrest.services.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/v1/categories")
class CategoryController(val categoryService: CategoryService) {

    @GetMapping
    fun getAllCategories() =
            ResponseEntity(CategoryListDto(categoryService.getAllCategories()), HttpStatus.OK)

    @GetMapping("/{name}")
    fun getCategoryByName(name: String) =
            ResponseEntity(categoryService.getCategoryByName(name), HttpStatus.OK)
}