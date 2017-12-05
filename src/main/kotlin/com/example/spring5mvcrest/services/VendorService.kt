package com.example.spring5mvcrest.services

import com.example.spring5mvcrest.api.v1.model.VendorDto

interface VendorService {

    fun getAllVendors(): List<VendorDto>
    fun getVendorById(name: String): VendorDto?
    fun createNewVendor(vendorDto: VendorDto): VendorDto
    fun saveVendor(id: String, vendorDto: VendorDto): VendorDto
    fun deleteVendorById(id: String)

}