package com.example.backend_minor;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByName(String name);
    List<Product> findByTags(String tags);

    List<Product> findByNameAndTags(String name, String tags);

    List<Product> findAll();

    void deleteById(int id);

}
