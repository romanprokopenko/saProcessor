package kpi.diploma.suffixarrayservice;

import kpi.diploma.suffixarray.SuffixArray;
import kpi.diploma.suffixarrayservice.request.SingleSubstringSearchRequest;
import kpi.diploma.suffixarrayservice.response.SuffixArrayServiceResponse;

import java.util.Objects;

public class SuffixArrayService {

    public SuffixArrayServiceResponse singleSubstringSearch(SingleSubstringSearchRequest request) {
        Objects.requireNonNull(request);

        SuffixArray suffixArray = new SuffixArray(request.getSourceText());

        return null;
    }

    
}
