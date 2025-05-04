package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {

    private final String productName;


    public String getProductName() {
        return productName;
    }

    public abstract int getCostOfProduct();


    public Product(String productName) {
        this.productName = productName;

    }

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return " PRODUCT ";
    }
}
