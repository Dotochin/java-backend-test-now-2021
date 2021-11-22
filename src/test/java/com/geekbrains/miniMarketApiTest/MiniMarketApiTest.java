package com.geekbrains.miniMarketApiTest;

import com.geekbrains.retrofit.api.MiniMarketApiServic;
import com.geekbrains.retrofit.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MiniMarketApiTest {

    private static MiniMarketApiServic apiService;

    @BeforeAll
    static void beforeAll() {

        apiService = new MiniMarketApiServic();
    }

    @Test
    void testGetProductById() throws IOException {
        Product product = apiService.getProduct(1);
        Assertions.assertEquals(1L, product.getId());
        Assertions.assertEquals("Milk", product.getTitle());
        Assertions.assertEquals("Food", product.getCategoryTitle());
    }

    @Test
    void testGetException404() throws IOException {

        Assertions.assertThrows(RuntimeException.class, () -> {
            Product product = apiService.getProduct(100);
        });
    }

    @Test
    void testGetProducts() throws IOException {
        List<Product> getProduct = apiService.getProducts();
    }

    @Test
    void testCreateProduct() throws IOException {
        Product createProduct = apiService.getProduct(1);

    }

    @Test
    void testModifyProduct() throws IOException {
        Product modifyProduct = apiService.getProduct(1);
    }

    @Test
    void testDeleteProductById() throws IOException {
        Product product = apiService.getProduct(1);
        Assertions.assertEquals(1L, product.getId());
        Assertions.assertEquals("Milk", product.getTitle());
        Assertions.assertEquals("Food", product.getCategoryTitle());
    }
}



