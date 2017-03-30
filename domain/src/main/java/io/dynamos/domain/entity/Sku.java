package io.dynamos.domain.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class Sku implements Serializable {

    @NotNull
    @Column(name = "identifier", nullable = false)
    private String identifier;

    @NotNull
    @Column(name = "weight", nullable = false)
    private Double weight;

    @NotNull
    @Column(name = "length", nullable = false)
    private Double length;

    @NotNull
    @Column(name = "height", nullable = false)
    private Double height;

    @NotNull
    @Column(name = "diameter", nullable = false)
    private Double diameter;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    @NotNull
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "instructions_for_use", nullable = false)
    private String instructionsForUse;

    @NotNull
    @Column(name = "manafacturer_the_warranty_time", nullable = false)
    private Integer manafacturerTheWarrantyTime;

    @NotNull
    @Column(name = "store_warranty_time", nullable = false)
    private Integer storeWarrantyTime;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Long amount;

    @NotNull
    @Column(name = "amount_reserved", nullable = false)
    private Long amountReserved;

    @ManyToOne
    @JoinColumn(name = "manafacturer_id")
    private Manafacturer manafacturer;

    @ManyToOne
    @JoinColumn(name = "custom_format_id")
    private TransportFormat transportFormat;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ProductAttribute> attributes = new HashSet<>();

    public Long getamountAvailable(){
        return this.amount - this.amountReserved;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getInstructionsForUse() {
        return instructionsForUse;
    }

    public void setInstructionsForUse(String instructionsForUse) {
        this.instructionsForUse = instructionsForUse;
    }

    public Integer getManafacturerTheWarrantyTime() {
        return manafacturerTheWarrantyTime;
    }

    public void setManafacturerTheWarrantyTime(Integer manafacturerTheWarrantyTime) {
        this.manafacturerTheWarrantyTime = manafacturerTheWarrantyTime;
    }

    public Integer getStoreWarrantyTime() {
        return storeWarrantyTime;
    }

    public void setStoreWarrantyTime(Integer storeWarrantyTime) {
        this.storeWarrantyTime = storeWarrantyTime;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmountReserved() {
        return amountReserved;
    }

    public void setAmountReserved(Long amountReserved) {
        this.amountReserved = amountReserved;
    }

    public Manafacturer getManafacturer() {
        return manafacturer;
    }

    public void setManafacturer(Manafacturer manafacturer) {
        this.manafacturer = manafacturer;
    }

    public TransportFormat getTransportFormat() {
        return transportFormat;
    }

    public void setTransportFormat(TransportFormat transportFormat) {
        this.transportFormat = transportFormat;
    }

    public Set<ProductAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<ProductAttribute> productAttributes) {
        this.attributes = productAttributes;
    }


}
