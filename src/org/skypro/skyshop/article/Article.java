package org.skypro.skyshop.article;

import java.util.Objects;

public class Article implements Searchable, Comparable<Article> {

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle, articleContent);
    }

    @Override
    public int compareTo(Article other) {
        if (other == null) return -1;
        if (this.articleTitle == null && other.articleTitle == null) return -1;
        if (this.articleTitle == null) return 1;
        if (other.articleTitle == null) return -1;
        int lengthCompare = Integer.compare(other.articleTitle.length(), this.articleTitle.length());
        if (lengthCompare!=0){
            return lengthCompare;
        }
        return this.articleTitle.compareTo(other.articleTitle);
    }
}



