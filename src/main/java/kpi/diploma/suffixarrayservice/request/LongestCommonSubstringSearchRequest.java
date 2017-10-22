package kpi.diploma.suffixarrayservice.request;

import java.util.Objects;

public class LongestCommonSubstringSearchRequest {

    public static final String STRING_SEPARATOR = "\u001F";

    private String firstString;
    private String secondString;

    public String getFirstString() {
        return firstString;
    }

    public void setFirstString(String firstString) {
        this.firstString = firstString;
    }

    public String getSecondString() {
        return secondString;
    }

    public void setSecondString(String secondString) {
        this.secondString = secondString;
    }

    public LongestCommonSubstringSearchRequest(String firstString, String secondString) {
        this.firstString = Objects.requireNonNull(firstString);
        this.secondString = Objects.requireNonNull(secondString);
    }

    public String getUnitedStrings() {
        return this.firstString + STRING_SEPARATOR + this.secondString;
    }
}
