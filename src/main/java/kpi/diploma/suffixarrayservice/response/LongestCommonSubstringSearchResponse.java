package kpi.diploma.suffixarrayservice.response;

public class LongestCommonSubstringSearchResponse implements SuffixArrayServiceResponse {

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

    public LongestCommonSubstringSearchResponse(String substring, Integer startIndex, Integer length) {
        this.substring = substring;
        this.startIndex = startIndex;
        this.length = length;
    }

    @Override
    public String toString() {
        return "LongestCommonSubstringSearchResponse{" +
                "substring='" + substring + '\'' +
                ", startIndex=" + startIndex +
                ", length=" + length +
                '}';
    }
}
