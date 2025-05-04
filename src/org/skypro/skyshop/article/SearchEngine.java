package org.skypro.skyshop.article;

public class SearchEngine {

    private final Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.size = 0;
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < this.size; i++) {
            if (this.searchables[i] != null &&
                    this.searchables[i].getSearchTerm() != null &&
                    this.searchables[i].getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results[resultCount] = this.searchables[i];
                resultCount++;
                if (resultCount == 5) {
                    break;
                }
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        if (this.size < this.searchables.length) {
            this.searchables[this.size] = searchable;
            this.size++;
        }
    }

    public void printResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result);
            }
        }
    }
}

