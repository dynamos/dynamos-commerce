package com.dynamos.domain.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A PromotionalCode.
 */
@Entity
@Table(name = "rhino_promotional_code")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PromotionalCode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Min(value = 0)
    @Column(name = "percentage_discount", nullable = false)
    private Integer percentageDiscount;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Min(value = 1)
    @Column(name = "amount_of_user")
    private Long amountOfUser;

    @Column(name = "amount_of_use")
    private Long amountOfUse;

    @ManyToOne
    @JoinColumn(name = "user_created")
    private User userCreated;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "promotional_code_customer_can_use",
            joinColumns = @JoinColumn(name = "promotional_code_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "ID"))
    private Set<Customer> customerCanUse = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "promotional_code_product_category",
            joinColumns = @JoinColumn(name = "promotional_codes_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "product_categorys_id", referencedColumnName = "ID"))
    private Set<ProductCategory> productCategory = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "promotional_code_product",
            joinColumns = @JoinColumn(name = "promotional_codes_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "products_id", referencedColumnName = "ID"))
    private Set<Product> products = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(Integer percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getAmountOfUser() {
        return amountOfUser;
    }

    public void setAmountOfUser(Long amountOfUser) {
        this.amountOfUser = amountOfUser;
    }

    public Long getAmountOfUse() {
        return amountOfUse;
    }

    public void setAmountOfUse(Long amountOfUse) {
        this.amountOfUse = amountOfUse;
    }

    public Set<Customer> getCustomerCanUse() {
        return customerCanUse;
    }

    public void setCustomerCanUse(Set<Customer> customer) {
        this.customerCanUse = customer;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User user) {
        this.userCreated = user;
    }

    public Set<ProductCategory> getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Set<ProductCategory> productCategory) {
        this.productCategory = productCategory;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PromotionalCode promotionalCode = (PromotionalCode) o;

        return Objects.equals(id, promotionalCode.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PromotionalCode{" +
                "id=" + id +
                ", code='" + code + "'" +
                ", percentageDiscount='" + percentageDiscount + "'" +
                ", expirationDate='" + expirationDate + "'" +
                ", amountOfUser='" + amountOfUser + "'" +
                ", amountOfUse='" + amountOfUse + "'" +
                '}';
    }
}
