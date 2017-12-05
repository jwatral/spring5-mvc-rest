package com.example.spring5mvcrest.bootstrap

import com.example.spring5mvcrest.domain.Category
import com.example.spring5mvcrest.domain.Customer
import com.example.spring5mvcrest.domain.Vendor
import com.example.spring5mvcrest.repositories.CategoryRepository
import com.example.spring5mvcrest.repositories.CustomerRepository
import com.example.spring5mvcrest.repositories.VendorRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Bootstrap(val categoryRepository: CategoryRepository,
                val customerRepository: CustomerRepository,
                val vendorRepository: VendorRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {

        val fruits = Category().apply { name = "fruits" }
        val dried = Category().apply { name = "dried" }
        val fresh = Category().apply { name = "fresh" }
        val exotic = Category().apply { name = "exotic" }
        val nuts = Category().apply { name = "nuts" }

        categoryRepository.saveAll(listOf(fruits, dried, fresh, exotic, nuts))

        val user1 = Customer().apply { firstName = "Joe"; lastName = "Newman" }
        val user2 = Customer().apply { firstName = "Michael"; lastName = "Lachappele" }
        val user3 = Customer().apply { firstName = "David"; lastName = "Winter" }
        val user4 = Customer().apply { firstName = "Anne"; lastName = "Hine" }
        val user5 = Customer().apply { firstName = "Alice"; lastName = "Eastman" }
        val user6 = Customer().apply { firstName = "Sam"; lastName = "Axe" }
        val user7 = Customer().apply { firstName = "Sam 2"; lastName = "Axe 2" }
        val user8 = Customer().apply { firstName = "Micheal 2"; lastName = "Weston 2" }
        val user9 = Customer().apply { firstName = "Joe"; lastName = "Buck" }
        val user10 = Customer().apply { firstName = "Sanjin"; lastName = "Dumančić" }

        customerRepository.saveAll(listOf(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10))

        val vendor1 = Vendor().apply { name = "Exotic Fruits Company" }
        val vendor2 = Vendor().apply { name = "Home Fruits" }
        val vendor3 = Vendor().apply { name = "Fun Fresh Fruits Ltd." }
        val vendor4 = Vendor().apply { name = "Nuts for Nuts Company" }
        val vendor5 = Vendor().apply { name = "Western Tasty Fruits Ltd." }

        vendorRepository.saveAll(listOf(vendor1, vendor2, vendor3, vendor4, vendor5))
    }

}