package kpi.diploma.suffixarrayservice.request;

import java.util.Objects;

public class SingleSubstringSearchRequest {

    private String sourceText;
    private String searchedText;

    public String getSourceText() {
        return sourceText;
    }

    public String getSearchedText() {
        return searchedText;
    }

    public SingleSubstringSearchRequest(String sourceText, String searchedText) {
        this.sourceText = Objects.requireNonNull(sourceText);
        this.searchedText = Objects.requireNonNull(searchedText);
    }
}
