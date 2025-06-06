package org.skypro.skyshop.article;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    String getProductName();

    default String getStringRepresentation() {
        return getProductName() + " - " + getContentType();
    }

}
