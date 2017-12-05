package com.example.spring5mvcrest.services

import com.example.spring5mvcrest.api.v1.model.CustomerDto

interface CustomerService {

    fun getAllCustomers(): List<CustomerDto>
    fun getCustomerById(name: String): CustomerDto?
    fun createNewCustomer(customerDto: CustomerDto): CustomerDto
    fun saveCustomer(id: String, customerDto: CustomerDto): CustomerDto
    fun deleteCustomerById(id: String)

}