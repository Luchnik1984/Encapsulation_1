package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable, Comparable<Product> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null|| getClass()!=o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName,product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }

    @Override
    public int compareTo(Product other) {
        if (other == null) return -1;
        if (this.productName == null && other.productName == null) return 0;
        if (this.productName == null) return 1;
        if (other.productName == null) return -1;

        int lengthCompare = Integer.compare(other.productName.length(), this.productName.length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }

        return this.productName.compareTo(other.productName);
    }
}
