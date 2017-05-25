package io.dynamos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
@Document(collection = "product_category")
public class ProductCategory {

    @Id
    private String id;

    @NotNull
    @Size(min = 3, max = 20)
    @Field("name")
    private String name;

    @DBRef
    @Field("parent_category")
    private ProductCategory parentCategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ProductCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}