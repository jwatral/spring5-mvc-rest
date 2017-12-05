package com.example.spring5mvcrest.services

import com.example.spring5mvcrest.api.v1.model.CustomerDto
import com.example.spring5mvcrest.domain.Customer
import com.example.spring5mvcrest.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(val customerRepository: CustomerRepository) : CustomerService {
    override fun saveCustomer(id: String, customerDto: CustomerDto) =
            customerRepository.save(customerDto.toCustomer().apply { this.id = id }).toDto()

    override fun createNewCustomer(customerDto: CustomerDto): CustomerDto {
        return customerRepository.save(customerDto.toCustomer()).toDto()
    }

    override fun getAllCustomers(): List<CustomerDto> {
        return customerRepository.findAll().map(Customer::toDto)
    }

    override fun getCustomerById(id: String): CustomerDto? {
        return customerRepository.findById(id).map(Customer::toDto).orElseThrow { RuntimeException("Nope") }
    }

    override fun deleteCustomerById(id: String) = customerRepository.deleteById(id)
}

fun Customer.toDto(): CustomerDto {
    return CustomerDto().apply { firstname = firstName; lastname = lastName; customer_url = "/api/v1/customers/$id" }
}

fun CustomerDto.toCustomer(): Customer {
    return Customer().apply { firstName = firstname; lastName = lastname }
}