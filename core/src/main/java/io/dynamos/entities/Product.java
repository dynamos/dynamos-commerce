package io.dynamos.entities;

import io.dynamos.entities.enums.ProductStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Created by adelmo on 22/04/17.
 */
public class Product {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String model;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Field("quantity_on_stock")
    private Long quantityOnStock;

    @NotNull
    private ProductStatus status;

    @DBRef
    @NotNull
    private Manufacturer manufacturer;

    @DBRef
    @Field("product_category")
    private ProductCategory productCategory;

    private List<Attribute> attributes;

    private List<String> images;

    public ProductStatus getStatus() {
        if (Objects.nonNull(status)) {
            if (Objects.nonNull(quantityOnStock) && quantityOnStock <= 10) {
                return ProductStatus.LOW_QUANTITY;
            }
        }
        return status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantityOnStock() {
        return quantityOnStock;
    }

    public void setQuantityOnStock(Long quantityOnStock) {
        this.quantityOnStock = quantityOnStock;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

}