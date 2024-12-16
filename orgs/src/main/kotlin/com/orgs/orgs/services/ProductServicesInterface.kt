package com.orgs.orgs.services

import com.orgs.orgs.models.Product
import java.util.*

interface ProductServicesInterface {

    fun create(product: Product): Product

    fun getAll(): List<Product>

    fun getById(id: Long) : Optional<Product>

    fun update(id: Long, product: Product): Optional<Product>

    fun delete(id: Long)

}