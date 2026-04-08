package com.example.ecom.product.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductConstructorAndGetters() {
        String name = "Test Product";
        String description = "Description";
        BigDecimal price = new BigDecimal("10.00");

        Product product = new Product(name, description, price);

        assertEquals(name, product.getName());
        assertEquals(description, product.getDescription());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void testSetters() {
        Product product = new Product();
        product.setId(1L);
        product.setName("New Name");

        assertEquals(Long.valueOf(1L), product.getId());
        assertEquals("New Name", product.getName());
    }
}
