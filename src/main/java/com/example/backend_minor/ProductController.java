package com.example.backend_minor;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ElasticsearchOperations elasticsearchOperations;


    private ProductRepository productRepository;

    @Autowired
    ProductController(ElasticsearchOperations elasticsearchOperations, ProductRepository productRepository){
        this.productRepository = productRepository;
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Product get_by_id(@PathVariable("id") long id){
        return elasticsearchOperations.get(String.valueOf(id), Product.class);
    }

    @GetMapping
    @RequestMapping("/all")
    public List<Product> get_all(){
        return productRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/name")
    public List<Product> get_by_name(String name){
        return productRepository.findByName(name);
    }

    @GetMapping
    @RequestMapping("/nameandtags")
    public List<Product> get_by_name_and_tags(String name, String tags){
        return productRepository.findByNameAndTags(name, tags);
    }


    @GetMapping
    @RequestMapping("/tags")
    public List<Product> get_by_tags(String tags){
        return productRepository.findByTags(tags);
    }

    @PostMapping
    public void create_product(Product product){
        elasticsearchOperations.save(product);
    }

    @DeleteMapping
    public void delete_by_id(int id){
        productRepository.deleteById(id);
    }
}
