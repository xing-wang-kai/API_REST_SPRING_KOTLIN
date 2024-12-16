package com.orgs.orgs.services

import com.orgs.orgs.models.Product
import com.orgs.orgs.repository.ProductsRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import java.util.*

@Service
class ProductServicesImpl(private val repository: ProductsRepository) : ProductServicesInterface {
    override fun create(product: Product): Product {

        Assert.hasLength(product.title, "[Title] Can't be empty!")
        Assert.isTrue(product.title.length >= 5, "[Title] this field need have 5 or more Characteres!")
        return repository.save(product)
    }

    override fun getAll(): List<Product> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Product> {
        return repository.findById(id)
    }

    override fun update(id: Long, product: Product): Optional<Product> {
        val optional = this.getById(id)
        if(optional.isEmpty) Optional.empty<Product>()
        return optional.map {
            val productTOUpdate = it.copy(
                title = product.title,
                description = product.description,
                price = product.price,
                imgUrl = product.imgUrl,
                userId = product.userId
            )
            repository.save(productTOUpdate)
        }
    }

    override fun delete(id: Long) {
        this.getById(id).map {
            repository.delete(it)
        }.orElseThrow{throw RuntimeException("Id $id Não foi encontrado")}
    }
}