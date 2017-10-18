package kpi.diploma.suffixarrayservice.util;

import kpi.diploma.suffixarray.SuffixArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SingleSubstringSearch {

    public static final String STRING_NOT_FOUND = "String not found";
    public static final String START_INDEX_SHOULD_BE_LESS_THAN_ZERO = "start index should be less than zero";
    public static final String SEARCHED_STRING_SHOULD_NOT_BE_EMPTY = "Searched string should not be empty";

    private SuffixArray suffixArray;

    public SingleSubstringSearch(SuffixArray suffixArray) {
        Objects.requireNonNull(suffixArray);
        this.suffixArray = suffixArray;
    }

    public SearchResult search(String searchedString) {
        Objects.requireNonNull(searchedString);
        if (searchedString.isEmpty()) {
            throw new IllegalArgumentException(SEARCHED_STRING_SHOULD_NOT_BE_EMPTY);
        }

        if (!isSearchedStringSuitable(searchedString)) {
            throw new SearchException(STRING_NOT_FOUND);
        }

        Integer leftBoundIndex = this.searchLeftBoundIndex(searchedString);
        Integer rightBoundIndex = this.searchRightBoundIndex(searchedString, leftBoundIndex);

        if (leftBoundIndex.equals(rightBoundIndex) &&
                !getSuffixAt(leftBoundIndex).startsWith(searchedString)){

            throw new SearchException(STRING_NOT_FOUND);
        }

        return new SearchResult(leftBoundIndex, rightBoundIndex);
    }

    private Boolean isSearchedStringSuitable(String searchedString) {
        int startIndex = 0;
        int endIndex = this.suffixArray.getSuffixArray().size() - 1;
        return (searchedString.compareTo(this.getSuffixAt(startIndex)) >= 0) &&
                (searchedString.compareTo(this.getSuffixAt(endIndex)) <= 0);
    }

    private Integer searchLeftBoundIndex(String searchedString) {
        Objects.requireNonNull(this.suffixArray.getSourceText());
        int leftIndex = 0;
        int rightIndex = this.suffixArray.getSourceText().length();
        while (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (searchedString.compareTo(this.getSuffixAt(mid)) > 0) {
                leftIndex = mid + 1;
            } else {
                rightIndex = mid;
            }
        }
        return leftIndex;
    }

    private Integer searchRightBoundIndex(String searchedString, Integer leftBoundIndex) {
        Objects.requireNonNull(this.suffixArray.getSourceText());
        int leftIndex = leftBoundIndex;
        int rightIndex = this.suffixArray.getSourceText().length();
        while (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (searchedString.compareTo(this.getSuffixAt(mid, searchedString.length())) < 0) {
                rightIndex = mid;
            } else {
                leftIndex = mid + 1;
            }
        }
        return rightIndex;
    }

    private String getSuffixAt(Integer index) {
        int suffixArrayPointer = this.suffixArray.getSuffixArray().get(index);
        return this.suffixArray.getSourceText().substring(suffixArrayPointer);
    }

    private String getSuffixAt(Integer index, int suffixSize) {
        int suffixArrayPointer = this.suffixArray.getSuffixArray().get(index);
        String suffix = this.suffixArray.getSourceText().substring(suffixArrayPointer);
        if (suffix.length() > suffixSize) {
            suffix = suffix.substring(0, suffixSize);
        }
        return suffix;
    }

    public class SearchResult {
        private Integer startIndex;
        private Integer endIndex;

        public SearchResult(Integer startIndex, Integer endIndex) {
            Objects.requireNonNull(startIndex);
            Objects.requireNonNull(endIndex);
            if (startIndex > endIndex) {
                throw new IllegalArgumentException(START_INDEX_SHOULD_BE_LESS_THAN_ZERO);
            } else if (endIndex - startIndex <= 0) {
                throw new SearchException(STRING_NOT_FOUND);
            }

            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public List<Integer> constructOccurencesList() {
            List<Integer> occurences = new ArrayList<>();
            for (int i = this.startIndex; i < this.endIndex; i++) {
                occurences.add(suffixArray.getSuffixArray().get(i));
            }

            return occurences;
        }
    }
}
