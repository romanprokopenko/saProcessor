package kpi.diploma.suffixarrayservice.util;

import kpi.diploma.suffixarray.SuffixArray;
import kpi.diploma.suffixarrayservice.request.LongestCommonSubstringSearchRequest;

import java.util.*;

public class LongestCommonSubstringSearch {

    private SuffixArray suffixArray;

    public LongestCommonSubstringSearch(SuffixArray suffixArray) {
        Objects.requireNonNull(suffixArray);
        this.suffixArray = suffixArray;
    }

    public SearchResult search() {
        String stringSeparator = LongestCommonSubstringSearchRequest.STRING_SEPARATOR;
        SortedLcpArray sortedLcpArray = new SortedLcpArray(this.suffixArray.getLcpArray());

        IndexValuePair searchedIndexValuePair = null;
        for (IndexValuePair indexValuePair : sortedLcpArray.getSortedLcpArray()) {
            if (indexValuePair.getValue().equals(0)) break;

            Integer currentIndex = indexValuePair.getIndex();
            String firstSuffix = this.getSuffixAt(currentIndex);
            String secondSuffix = this.getSuffixAt(currentIndex + 1);

            if (secondSuffix.contains(stringSeparator) && !firstSuffix.contains(stringSeparator) ||
                    firstSuffix.contains(stringSeparator) && !secondSuffix.contains(stringSeparator)) {

                searchedIndexValuePair = indexValuePair;
                break;
            }
        }

        if (searchedIndexValuePair == null) {
            throw new SearchException("Common substring not found");
        }

        return new SearchResult(searchedIndexValuePair);
    }

    private String getSuffixAt(Integer index) {
        int suffixArrayPointer = this.suffixArray.getSuffixArray().get(index);
        return this.suffixArray.getSourceText().substring(suffixArrayPointer);
    }

    public class SearchResult {

        private String substring;
        private Integer startIndex;
        private Integer length;

        public String getSubstring() {
            return substring;
        }

        public Integer getStartIndex() {
            return startIndex;
        }

        public Integer getLength() {
            return length;
        }

        public SearchResult(IndexValuePair indexValuePair) {
            this.startIndex = suffixArray.getSuffixArray().get(indexValuePair.getIndex());
            this.length = indexValuePair.getValue();

            this.substring = getSuffixAt(indexValuePair.getIndex()).substring(0, this.length);
        }
    }

    private class SortedLcpArray {

        private List<Integer> lcpArray;
        private List<IndexValuePair> sortedLcpArray;

        public List<IndexValuePair> getSortedLcpArray() {
            return sortedLcpArray;
        }

        public SortedLcpArray(List<Integer> lcpArray) {
            this.lcpArray = lcpArray;
            this.sortedLcpArray = constructSortedArray(lcpArray);
        }

        private List<IndexValuePair> constructSortedArray(List<Integer> lcpArray) {
            List<IndexValuePair> resultList = new ArrayList<>();
            for (int i = 0; i < lcpArray.size(); i++) {
                resultList.add(new IndexValuePair(i, lcpArray.get(i)));
            }

            resultList.sort((IndexValuePair a, IndexValuePair b) -> (b.getValue() - a.getValue()));

            return resultList;
        }


    }

    private class IndexValuePair {

        private Integer index;
        private Integer value;

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public IndexValuePair(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IndexValuePair that = (IndexValuePair) o;

            if (index != null ? !index.equals(that.index) : that.index != null) return false;
            return value != null ? value.equals(that.value) : that.value == null;
        }

        @Override
        public int hashCode() {
            int result = index != null ? index.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }
}
