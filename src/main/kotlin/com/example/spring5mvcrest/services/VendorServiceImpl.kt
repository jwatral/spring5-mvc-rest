package com.example.spring5mvcrest.services

import com.example.spring5mvcrest.api.v1.model.VendorDto
import com.example.spring5mvcrest.domain.Vendor
import com.example.spring5mvcrest.repositories.VendorRepository
import org.springframework.stereotype.Service

@Service
class VendorServiceImpl(val vendorRepository: VendorRepository) : VendorService {
    override fun saveVendor(id: String, vendorDto: VendorDto) =
            vendorRepository.save(vendorDto.toVendor().apply { this.id = id }).toDto()

    override fun createNewVendor(vendorDto: VendorDto): VendorDto {
        return vendorRepository.save(vendorDto.toVendor()).toDto()
    }

    override fun getAllVendors(): List<VendorDto> {
        return vendorRepository.findAll().map(Vendor::toDto)
    }

    override fun getVendorById(id: String): VendorDto? {
        return vendorRepository.findById(id).map(Vendor::toDto).orElseThrow { RuntimeException("Nope") }
    }

    override fun deleteVendorById(id: String) = vendorRepository.deleteById(id)
}

fun Vendor.toDto(): VendorDto {
    return VendorDto().apply { name = this@toDto.name; vendor_url = "/api/v1/vendors/$id" }
}

fun VendorDto.toVendor(): Vendor {
    return Vendor().apply { name = this@toVendor.name }
}