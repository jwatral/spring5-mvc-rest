package com.example.spring5mvcrest.controllers.v1

import com.example.spring5mvcrest.api.v1.model.CustomerDto
import com.example.spring5mvcrest.api.v1.model.CustomerListDto
import com.example.spring5mvcrest.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/v1/customers")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun getAllCustomers() =
            ResponseEntity(CustomerListDto(customerService.getAllCustomers()), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: String) =
            ResponseEntity(customerService.getCustomerById(id), HttpStatus.OK)

    @PostMapping
    fun createCustomer(@RequestBody customerDto: CustomerDto) =
            ResponseEntity(customerService.createNewCustomer(customerDto), HttpStatus.CREATED)

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: String, @RequestBody customerDto: CustomerDto) =
            ResponseEntity(customerService.saveCustomer(id, customerDto), HttpStatus.OK)

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: String) =
            ResponseEntity(customerService.deleteCustomerById(id), HttpStatus.OK)
}