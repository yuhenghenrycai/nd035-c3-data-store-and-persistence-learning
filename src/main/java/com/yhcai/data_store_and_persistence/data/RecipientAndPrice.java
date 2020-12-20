package com.yhcai.data_store_and_persistence.data;

import java.math.BigDecimal;

public class RecipientAndPrice {
    private String recipientName;
    private BigDecimal price;

    //You'll probably need a constructor like this so CriteriaBuilder can create
    public RecipientAndPrice(String recipientName, BigDecimal price) {
        this.recipientName = recipientName;
        this.price = price;
    }
    /* getters and setters */

    public String getRecipientName() {
        return recipientName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
