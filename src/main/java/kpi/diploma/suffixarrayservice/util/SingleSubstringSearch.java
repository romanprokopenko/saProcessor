package kpi.diploma.suffixarrayservice.util;

import kpi.diploma.suffixarray.SuffixArray;

import java.util.Objects;

public class SingleSubstringSearch {

    private SuffixArray suffixArray;

    public SingleSubstringSearch(SuffixArray suffixArray) {
        Objects.requireNonNull(suffixArray);
        this.suffixArray = suffixArray;
    }

    public SearchResult search(String searchedString) {
        Objects.requireNonNull(searchedString);
        if (searchedString.isEmpty()) {
            throw new IllegalArgumentException("searched string should not be empty");
        }

        if (!isSearchedStringSuitable(searchedString)) {
            return new SearchResult();
        }

        Integer leftBoundIndex = this.searchLeftBoundIndex(searchedString);
        Integer rightBoundIndex = this.searchRightBoundIndex(searchedString, leftBoundIndex);

        return new SearchResult(leftBoundIndex, rightBoundIndex);
    }

    private Boolean isSearchedStringSuitable(String searchedString) {
        int startIndex = 0;
        int endIndex = this.suffixArray.getSuffixArray().size() - 1;
        return (searchedString.compareTo(this.getSuffixAt(startIndex)) < 0) ||
                (searchedString.compareTo(this.getSuffixAt(endIndex))  > 0);
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
            if (searchedString.compareTo(this.getSuffixAt(mid)) < 0) {
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

    public class SearchResult {
        private Integer startIndex;
        private Integer endIndex;

        public SearchResult() {
            this.startIndex = -1;
            this.endIndex = -1;
        }

        public SearchResult(Integer startIndex, Integer endIndex) {
            Objects.requireNonNull(startIndex);
            Objects.requireNonNull(endIndex);
            if (startIndex > endIndex) {
                throw new IllegalArgumentException("start index should be less than zero");
            }

            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public boolean isStringFound() {
            return startIndex < 0 || endIndex < 0;
        }
    }
}
