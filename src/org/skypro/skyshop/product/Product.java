package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {

    private final String productName;


    public Product(String productName) {
        if (productName == null) {
            throw new IllegalArgumentException("Продукт без названия или продукт отсутствует!");
        }
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой!");
        }
        this.productName = productName;

    }

    public String getProductName() {
        return productName;
    }

    public abstract int getCostOfProduct();

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
