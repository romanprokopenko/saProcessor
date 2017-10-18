package kpi.diploma.suffixarrayservice;

import kpi.diploma.suffixarray.SuffixArray;
import kpi.diploma.suffixarrayservice.request.SingleSubstringSearchRequest;
import kpi.diploma.suffixarrayservice.response.SingleSubstringSearchResponse;
import kpi.diploma.suffixarrayservice.response.SuffixArrayServiceResponse;
import kpi.diploma.suffixarrayservice.util.SingleSubstringSearch;

import java.util.Objects;

public class SuffixArrayService {

    public SuffixArrayServiceResponse singleSubstringSearch(SingleSubstringSearchRequest request) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(request.getSourceText());
        Objects.requireNonNull(request.getSearchedText());

        SuffixArray suffixArray = new SuffixArray(request.getSourceText());
        SingleSubstringSearch searchProcess = new SingleSubstringSearch(suffixArray);
        SingleSubstringSearch.SearchResult searchResult = searchProcess.search(request.getSearchedText());

        return new SingleSubstringSearchResponse(searchResult.constructOccurencesList());
    }


    
}
