package kpi.diploma.suffixarray;

import java.util.*;

public class LcpArray {

    private List<Integer> lcpArray;

    public List<Integer> getLcpArray() {
        return lcpArray;
    }

    public LcpArray(String sourceText, List<Integer> suffixArray) {
        this.lcpArray = constructLcpArray(sourceText, suffixArray);
    }

    @org.jetbrains.annotations.NotNull
    private List<Integer> constructLcpArray(String sourceText, List<Integer> suffixArray) {
        Objects.requireNonNull(sourceText);
        Objects.requireNonNull(suffixArray);
        Integer[] lcpArray = new Integer[suffixArray.size()];
        Arrays.fill(lcpArray, 0);
        Integer[] inverseSuffixArray = new Integer[suffixArray.size()];

        for (int i = 0; i < suffixArray.size(); i++) {
            inverseSuffixArray[suffixArray.get(i)] = i;
        }

        int k = 0;

        for (int i = 0; i < suffixArray.size(); i++) {
            if (inverseSuffixArray[i].equals(suffixArray.size() - 1)) {
                k = 0;
                continue;
            }

            int j = suffixArray.get(inverseSuffixArray[i] + 1);
            while (((i + k) < suffixArray.size()) && (sourceText.charAt(i + k) == sourceText.charAt(j + k))) {
                k++;
            }

            lcpArray[inverseSuffixArray[i]] = k;
            if (k > 0) {
                k--;
            }
        }

        return Arrays.asList(lcpArray);
    }
}
