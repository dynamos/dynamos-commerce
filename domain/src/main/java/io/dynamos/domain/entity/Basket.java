package com.dynamos.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Basket.
 */
@Entity
@Table(name = "rhino_basket")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Basket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @NotNull
    @Min(value = 0)
    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @JsonIgnore
    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ItemBasket> items = new HashSet<>();

    @OneToOne
    private Customer customer;

    public void setAmount() {
        BigDecimal amount = new BigDecimal(0L);

        items.forEach(e ->  amount.add(e.getTotalPrice()));

        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Set<ItemBasket> getItems() {
        return items;
    }

    public void setItems(Set<ItemBasket> itemBaskets) {
        this.items = itemBaskets;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Basket basket = (Basket) o;

        return Objects.equals(id, basket.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", creationDate='" + creationDate + "'" +
                ", amount='" + amount + "'" +
                '}';
    }
}
