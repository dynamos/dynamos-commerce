package io.dynamos.entities;

import io.dynamos.entities.enums.ProductStatus;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Created by adelmo on 22/04/17.
 */
public class Product {

    @Id
    private String identifier;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Manufacturer manufacturer;

    @NotNull
    private String model;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Long quantityOnStock;

    @NotNull
    private ProductStatus status;

    private List<Attribute> attributes;

    private List<String> images;


    public ProductStatus getStatus() {
        if (Objects.nonNull(status)) {
            if (quantityOnStock <= 10) {
                return ProductStatus.LOW_QUANTITY;
            }
        }

        return status;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
