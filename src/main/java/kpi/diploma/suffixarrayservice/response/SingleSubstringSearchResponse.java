package kpi.diploma.suffixarrayservice.response;

import java.util.List;

public class SingleSubstringSearchResponse implements SuffixArrayServiceResponse {

    private List<Integer> occurences;

    public List<Integer> getOccurences() {
        return occurences;
    }

    public SingleSubstringSearchResponse(List<Integer> occurences) {
        this.occurences = occurences;
    }

    @Override
    public String toString() {
        return occurences.toString();
    }
}
