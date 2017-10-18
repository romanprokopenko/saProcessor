package kpi.diploma.suffixarray;

import kpi.diploma.suffixarray.library.Sais;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SuffixArray {
    private Sais sais = new Sais();
    private String sourceText;
    private List<Integer> suffixArray;
    private LcpArray lcpArray;

    public List<Integer> getSuffixArray() {
        return suffixArray;
    }

    public List<Integer> getLcpArray() {
        return this.lcpArray.getLcpArray();
    }

    public String getSourceText() {
        return sourceText;
    }

    public SuffixArray(String sourceText) {
        this.sourceText = sourceText + "\u0000";
        this.suffixArray = this.constructSuffixArray(this.sourceText);
        this.lcpArray = new LcpArray(this.sourceText, this.suffixArray);
    }

    @org.jetbrains.annotations.NotNull
    private List<Integer> constructSuffixArray(String text) {
        Objects.requireNonNull(text);

        int[] temporaryArray = new int[text.length()];
        this.sais.suffixsort(text, temporaryArray, text.length());

        return Arrays.asList(ArrayUtils.toObject(temporaryArray));
    }


}
