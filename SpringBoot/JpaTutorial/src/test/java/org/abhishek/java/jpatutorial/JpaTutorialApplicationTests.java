package org.abhishek.java.jpatutorial;

import org.abhishek.java.jpatutorial.entities.ProductEntity;
import org.abhishek.java.jpatutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void textRepository() {
        ProductEntity productEntity= ProductEntity.builder()
                .sku("nestle")
                .title("Nestle chocolate")
                .price(BigDecimal.valueOf(123.45))
                .quantity(10)
                .build();

        ProductEntity savedProduct =    productRepository.save(productEntity);
        System.out.println(savedProduct);
    }

    @Test
    void getRepository() {

        List<ProductEntity> productList = productRepository.findAll();
         for (ProductEntity productEntity : productList) {
             System.out.println(productEntity);
         }
    }

    @Test
    void getProductByTitle(){
        List<ProductEntity> productList = productRepository.findByTitle("pepsi");
        System.out.println(productList);
    }
}
