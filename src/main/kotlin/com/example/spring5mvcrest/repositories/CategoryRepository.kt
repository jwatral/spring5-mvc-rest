package com.example.spring5mvcrest.repositories

import com.example.spring5mvcrest.domain.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, String> {
    fun findByName(name: String): Category?
}