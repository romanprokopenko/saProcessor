package kpi.diploma.suffixarray;

import kpi.diploma.suffixarray.library.Sais;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class SuffixArray {

    private Sais sais = new Sais();
    private String sourceText;
    private List<Integer> suffixArray;

    public List<Integer> getSuffixArray() {
        return suffixArray;
    }

    public String getSourceText() {
        return sourceText;
    }

    public SuffixArray(String sourceText) {
        this.sourceText = sourceText;
        this.suffixArray = this.generateSuffixArray(sourceText);
    }

    @org.jetbrains.annotations.NotNull
    private List<Integer> generateSuffixArray(String text) {
        int[] temporaryArray = new int[text.length()];
        this.sais.suffixsort(text, temporaryArray, text.length());

        return Arrays.asList(ArrayUtils.toObject(temporaryArray));
    }

}
