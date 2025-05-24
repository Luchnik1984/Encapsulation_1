package org.skypro.skyshop.article;

import org.skypro.skyshop.exeptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final List<Searchable> searchables = new ArrayList<>();


    public void add(Searchable searchable) {
        searchables.add(searchable);
    }


    public void search(String searchTerm) {


        for (Searchable searchable : searchables) {
            if (searchable != null &&
                    searchable.getSearchTerm() != null &&
                    searchable.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println(searchable);
            }
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
