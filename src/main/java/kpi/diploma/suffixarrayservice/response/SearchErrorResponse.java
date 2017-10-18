package kpi.diploma.suffixarrayservice.response;

public class SearchErrorResponse implements SuffixArrayServiceResponse {

    private String reason;

    public String getReason() {
        return reason;
    }

    public SearchErrorResponse(String reason) {
        this.reason = reason;
    }
}
