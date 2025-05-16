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
            if (this.searchables[i] != null &&
                    this.searchables[i].getSearchTerm() != null) {
                String str = this.searchables[i].getSearchTerm().toLowerCase();
                String substring = search.toLowerCase();
                int count = 0;
                int index = 0;
                int indexSubstring = str.indexOf(substring, index);
                while (indexSubstring != -1) {
                    count++;
                    index = indexSubstring + substring.length();
                    indexSubstring = str.indexOf(substring, index);
                }
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
}



