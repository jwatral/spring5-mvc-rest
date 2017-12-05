package com.example.spring5mvcrest.repositories

import com.example.spring5mvcrest.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, String> {
    fun findByLastName(name: String): Customer?
}