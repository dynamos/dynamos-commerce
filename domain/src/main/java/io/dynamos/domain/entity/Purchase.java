package io.dynamos.domain.entity;

import io.dynamos.domain.entity.enums.StatusPurchase;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Purchase.
 */
@Entity
@Table(name = "dyn_purchase")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 1)
    @Column(name = "tracking_number")
    private String trackingNumber;

    @NotNull
    @Min(value = 0)
    @Column(name = "final_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal finalPrice;

    @NotNull
    @Min(value = 0)
    @Column(name = "shipping_value", precision = 10, scale = 2, nullable = false)
    private BigDecimal shippingValue;

    @NotNull
    @Min(value = 0)
    @Column(name = "value_of_products", precision = 10, scale = 2, nullable = false)
    private BigDecimal valueOfProducts;

    @Min(value = 0)
    @Column(name = "discount_amount", precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @NotNull
    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "promotional_code_id")
    private PromotionalCode promotionalCode;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Customer buyer;

    @Enumerated
    private StatusPurchase statusPurchase;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ItemPurchase> itemPurchases = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusPurchase getStatusPurchase() {
        return statusPurchase;
    }

    public void setStatusPurchase(StatusPurchase statusPurchase) {
        this.statusPurchase = statusPurchase;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getShippingValue() {
        return shippingValue;
    }

    public void setShippingValue(BigDecimal shippingValue) {
        this.shippingValue = shippingValue;
    }

    public BigDecimal getValueOfProducts() {
        return valueOfProducts;
    }

    public void setValueOfProducts(BigDecimal valueOfProducts) {
        this.valueOfProducts = valueOfProducts;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public PromotionalCode getPromotionalCode() {
        return promotionalCode;
    }

    public void setPromotionalCode(PromotionalCode promotionalCode) {
        this.promotionalCode = promotionalCode;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer user) {
        this.buyer = buyer;
    }

    public Set<ItemPurchase> getItemPurchases() {
        return itemPurchases;
    }

    public void setItemPurchases(Set<ItemPurchase> itemPurchases) {
        this.itemPurchases = itemPurchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Purchase purchase = (Purchase) o;

        return Objects.equals(id, purchase.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", trackingNumber='" + trackingNumber + "'" +
                ", finalPrice='" + finalPrice + "'" +
                ", shippingValue='" + shippingValue + "'" +
                ", valueOfProducts='" + valueOfProducts + "'" +
                ", discountAmount='" + discountAmount + "'" +
                ", paymentDate='" + paymentDate + "'" +
                ", purchaseDate='" + purchaseDate + "'" +
                '}';
    }
}
