package com.example.ecom.product.repository;

import com.example.ecom.product.model.Product;
import com.example.ecom.product.model.QProduct;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findProductsByName(String name) {
        QProduct qProduct = QProduct.product;
        JPAQuery<Product> query = new JPAQuery<>(entityManager);

        return query.from(qProduct)
                .where(qProduct.name.containsIgnoreCase(name))
                .select(qProduct)
                .fetch();
    }

    @Override
    public List<Product> findProductsByPriceRange(java.math.BigDecimal minPrice, java.math.BigDecimal maxPrice) {
        QProduct qProduct = QProduct.product;
        JPAQuery<Product> query = new JPAQuery<>(entityManager);
        return query.from(qProduct)
                .where(qProduct.price.between(minPrice, maxPrice))
                .select(qProduct)
                .fetch();
    }

    @Override
    public List<Product> findProductsByDescriptionContains(String description) {
        QProduct qProduct = QProduct.product;
        JPAQuery<Product> query = new JPAQuery<>(entityManager);
        return query.from(qProduct)
                .where(qProduct.description.containsIgnoreCase(description))
                .select(qProduct)
                .fetch();
    }
}
