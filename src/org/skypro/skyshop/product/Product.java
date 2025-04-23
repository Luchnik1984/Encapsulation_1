package org.skypro.skyshop.product;

public class Product {

    private String productName;
    private int costOfProduct;

    public String getProductName() {
        return productName;
    }

    public int getCostOfProduct() {
        return costOfProduct;
    }

    public Product(String productName, int costOfProduct) {
        this.productName = productName;
        this.costOfProduct = costOfProduct;
    }

    @Override
    public String toString() {
        return
                '<' + productName + '>' +
                ": <" + costOfProduct +" руб."+
                '>';
    }
}
