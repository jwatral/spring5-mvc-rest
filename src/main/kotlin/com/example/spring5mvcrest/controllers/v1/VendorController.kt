package com.example.spring5mvcrest.controllers.v1

import com.example.spring5mvcrest.api.v1.model.VendorDto
import com.example.spring5mvcrest.api.v1.model.VendorListDto
import com.example.spring5mvcrest.services.VendorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/v1/vendors")
class VendorController(val vendorService: VendorService) {

    @GetMapping
    fun getAllVendors() =
            ResponseEntity(VendorListDto(vendorService.getAllVendors()), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getVendorById(@PathVariable id: String) =
            ResponseEntity(vendorService.getVendorById(id), HttpStatus.OK)

    @PostMapping
    fun createVendor(@RequestBody vendorDto: VendorDto) =
            ResponseEntity(vendorService.createNewVendor(vendorDto), HttpStatus.CREATED)

    @PutMapping("/{id}")
    fun updateVendor(@PathVariable id: String, @RequestBody vendorDto: VendorDto) =
            ResponseEntity(vendorService.saveVendor(id, vendorDto), HttpStatus.OK)

    @DeleteMapping("/{id}")
    fun deleteVendor(@PathVariable id: String) =
            ResponseEntity(vendorService.deleteVendorById(id), HttpStatus.OK)
}