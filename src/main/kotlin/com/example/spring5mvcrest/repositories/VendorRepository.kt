package com.example.spring5mvcrest.repositories

import com.example.spring5mvcrest.domain.Vendor
import org.springframework.data.jpa.repository.JpaRepository

interface VendorRepository : JpaRepository<Vendor, String> {
    fun findByName(name: String): Vendor?
}