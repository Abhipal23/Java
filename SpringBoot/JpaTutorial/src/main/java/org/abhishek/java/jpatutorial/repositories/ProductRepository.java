package org.abhishek.java.jpatutorial.repositories;

import org.abhishek.java.jpatutorial.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByTitle(String title);

    // hybernate will generate the corresponding query command

    // there is several rules and regulations for custom query methods

    // 1 : I wanted to fetch details that are created after certain time
    List<ProductEntity> findByCreatedAtAfter(LocalDate createdAt);

    // 2 :     i Wanted apply filter on the basis of price and quantity


    List<ProductEntity> findByQuantityAndPrice(Integer quantity, BigDecimal price);

    //
    List<ProductEntity> findByOrderByPrice();



    // all the query methods can be overloaded with sort parameter
       List<ProductEntity> findBy(Sort sort );
       // in controller we need to pass instance of sort
}