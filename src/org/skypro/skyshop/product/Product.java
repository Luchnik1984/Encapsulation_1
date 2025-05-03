package org.skypro.skyshop.product;

public abstract class Product {

    private final String productName;


    public String getProductName() {
        return productName;
    }

    public abstract int getCostOfProduct();


    public Product(String productName ) {
        this.productName = productName;

    }

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();

}
