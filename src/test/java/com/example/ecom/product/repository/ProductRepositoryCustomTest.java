package com.example.ecom.product.repository;

import com.example.ecom.product.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryCustomTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindProductsByPriceRange() {
        Product p1 = new Product();
        p1.setName("Cheap Product");
        p1.setPrice(new BigDecimal("10.00"));
        p1.setDescription("Cheap");
        productRepository.save(p1);

        Product p2 = new Product();
        p2.setName("Expensive Product");
        p2.setPrice(new BigDecimal("100.00"));
        p2.setDescription("Expensive");
        productRepository.save(p2);

        List<Product> result = productRepository.findProductsByPriceRange(new BigDecimal("5.00"),
                new BigDecimal("50.00"));

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Cheap Product");
    }

    @Test
    public void testFindProductsByDescriptionContains() {
        Product p1 = new Product();
        p1.setName("P1");
        p1.setPrice(new BigDecimal("10.00"));
        p1.setDescription("This is a test description");
        productRepository.save(p1);

        List<Product> result = productRepository.findProductsByDescriptionContains("test");

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("P1");
    }
}
