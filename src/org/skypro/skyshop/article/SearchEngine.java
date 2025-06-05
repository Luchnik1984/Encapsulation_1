package org.skypro.skyshop.article;

import org.skypro.skyshop.exeptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private final Set<Searchable> searchables = new HashSet<>();


    public void add(Searchable searchable) {
        searchables.add(searchable);
            }


    public Set<Searchable> search(String searchTerm) {
       Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        for (Searchable searchable : searchables) {
            if (searchable != null &&
                    searchable.getSearchTerm() != null &&
                    searchable.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(searchable);
            }
        }
        return results;
    }

    public void printResults(Set<Searchable> results) {
        int count = 0;
        if (results.isEmpty()) {
            count++;
            System.out.println("Результат поиска №" + count + ": Продукт не найден!");
            return;
        }

        for (Searchable result : results) {
            count++;
            System.out.println("Результат поиска №" + count + ": "  + result);
        }
    }


    public Searchable findBestSearchResult(String search) throws BestResultNotFound {
        Searchable bestSearchResult = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm() != null) {
                int count = countOccurrences(searchable.getSearchTerm(), search);

                if (count > maxCount) {
                    maxCount = count;
                    bestSearchResult = searchable;
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
