package kpi.org.suffixarray;

import kpi.org.suffixarray.library.Sais;
import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class SuffixArray {

    private Sais sais = new Sais();
    private List<Integer> suffixArray;

    public List<Integer> getSuffixArray() {
        return suffixArray;
    }


    public SuffixArray(String text) {
        this.suffixArray = this.generateSuffixArray(text);
    }

    @org.jetbrains.annotations.NotNull
    private List<Integer> generateSuffixArray(String text) {
        int[] temporaryArray = new int[text.length()];
        this.sais.suffixsort(text, temporaryArray, text.length());

        return Arrays.asList(ArrayUtils.toObject(temporaryArray));
    }

}
