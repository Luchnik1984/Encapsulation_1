package org.skypro.skyshop.article;

public class Article implements Searchable {

    private final String articleTitle;
    private final String articleContent;


    public Article(String articleTitle, String articleContent) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getSearchTerm() {
        return this.toString();
    }

    @Override
    public String getProductName() {
        return articleTitle;
    }

    @Override
    public String toString() {
        return
                "< " + articleTitle + " : " +
                        articleContent + " > ";
    }
}



