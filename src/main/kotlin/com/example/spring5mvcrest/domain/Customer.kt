package com.example.spring5mvcrest.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: String = ""
    lateinit var firstName: String
    lateinit var lastName: String
}
