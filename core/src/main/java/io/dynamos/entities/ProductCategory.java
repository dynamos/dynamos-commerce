package io.dynamos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Size;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
public class ProductCategory {

    @Id
    @Size(min = 3, max = 20)
    @Field("name")
    private String name;

    @Field
    private ProductCategory parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getParent() {
        return parent;
    }

    public void setParent(ProductCategory parent) {
        this.parent = parent;
    }
}
