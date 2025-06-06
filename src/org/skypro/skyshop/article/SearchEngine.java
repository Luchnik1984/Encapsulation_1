package org.skypro.skyshop.article;

import org.skypro.skyshop.exeptions.BestResultNotFound;

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

    public Searchable findBestSearchResult(String search) throws BestResultNotFound {
        Searchable bestSearchResult = null;
        int maxCount = 0;

        for (int i = 0; i < this.size; i++) {
            if (this.searchables[i] != null && this.searchables[i].getSearchTerm() != null) {
                int count = countOccurrences(this.searchables[i].getSearchTerm(), search);

                if (count > maxCount) {
                    maxCount = count;
                    bestSearchResult = this.searchables[i];
                }
            }
        }

        if (bestSearchResult == null) {
            throw new BestResultNotFound(search);
        }

        return bestSearchResult;
    }

    private int countOccurrences(String text, String searchTerm) {
        String str = text.toLowerCase();
        String substring = searchTerm.toLowerCase();
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }
}
