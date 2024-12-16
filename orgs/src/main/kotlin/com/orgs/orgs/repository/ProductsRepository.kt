package com.orgs.orgs.repository

import com.orgs.orgs.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsRepository: JpaRepository<Product, Long>{

}