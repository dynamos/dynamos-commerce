package io.dynamos.domain.entity.enums;

/**
 * Created by adelm_000 on 14/01/2016.
 */
public enum StatusPurchase {

    PAYMENT_PROCESSING("rhino.purchase.status.paymentProcessing"),
    INVOICE_PROCESSING("rhino.purchase.status.invoiceProcessing"),
    ON_CARRIAGE("rhino.purchase.status.onCarriage"),
    DELIVERED("rhino.purchase.status.delivered");

    private String description;

    StatusPurchase(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
