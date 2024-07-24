package org.abhishek.java.jpatutorial.controller;


import org.abhishek.java.jpatutorial.entities.ProductEntity;
import org.abhishek.java.jpatutorial.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    public ProductController( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

  private final  int PAGE_SIZE = 5;
  //  @GetMapping
//    List<ProductEntity> getAllProducts() {
//        return productRepository.findByOrderByPrice();
//    }

    // to use sort we can crete an instance of sort
//    Sort sort = Sort.by(Sort.Direction.ASC,sortFiled )\

   // Sort sort = Sort.by(Sort.Direction.DESC, "id")

    List<ProductEntity> findAll(@RequestParam(defaultValue = "title") String sortBy) {
//         return productRepository re.findAll(Sort.by(sortBy));
          // by default asc order
       // return productRepository.findAll(Sort.by(Sort.Direction.DESC,(sortBy)));
// now if two items having same sortBy value then ?

      //  return productRepository.findAll(Sort.by(Sort.Direction.DESC,(sortBy),"price"));

        // then based on price they will be sorted  i can add as many properties as we can

        // we have multiple ways to create sort instance
        return productRepository.findAll(Sort.by(
                Sort.Order.asc(sortBy),
                Sort.Order.desc("price")
        ));
        // first it will sort by sortBy if two fields have same type then it will sort by price
    }

    @GetMapping
    public List<ProductEntity> findAll(@RequestParam(defaultValue = "1")Integer pageNumber, @RequestParam(defaultValue = "title") String sortBy) {

        Pageable pageable = PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy));
        return productRepository.findAll(pageable).getContent();
        // .getContent will return a list insted of page
        // we can pass pageable any where in product repository
    }

}
