package kpi.diploma;

import kpi.diploma.suffixarrayservice.SuffixArrayService;
import kpi.diploma.suffixarrayservice.request.SingleSubstringSearchRequest;
import kpi.diploma.suffixarrayservice.response.SuffixArrayServiceResponse;

public class App {

    public static void main(String[] arg) {

        SingleSubstringSearchRequest request = new SingleSubstringSearchRequest("banana", "e");
        SuffixArrayService service = new SuffixArrayService();
        SuffixArrayServiceResponse response = service.singleSubstringSearch(request);
        System.out.println(response);
    }
}
