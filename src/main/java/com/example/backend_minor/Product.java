package com.example.backend_minor;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "presents")
@Data
@AllArgsConstructor
@TypeAlias("product")
public class Product {
    @Id
    private int id;

    @Field(type= FieldType.Text, name = "name")
    private String name;
    @Field(type = FieldType.Integer, name = "price")
    private int price;
    @Field(type = FieldType.Auto, name = "tags")
    private String tags;
    @Field(type = FieldType.Text, name = "description")
    private String description;
    @Field(type = FieldType.Text, name = "links")
    private String links;

}
