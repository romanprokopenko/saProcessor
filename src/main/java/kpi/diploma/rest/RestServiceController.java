package kpi.diploma.rest;

import kpi.diploma.suffixarrayservice.SuffixArrayService;
import kpi.diploma.suffixarrayservice.request.LongestCommonSubstringSearchRequest;
import kpi.diploma.suffixarrayservice.request.SingleSubstringSearchRequest;
import kpi.diploma.suffixarrayservice.response.SuffixArrayServiceResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RestServiceController {


    @RequestMapping(method = RequestMethod.POST, path = "/singlesearch")
    public SuffixArrayServiceResponse requestSingleSearch(@RequestBody SingleSubstringSearchRequest request) {
        SuffixArrayService service = new SuffixArrayService();
        SuffixArrayServiceResponse response = service.singleSubstringSearch(request);

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/lcssearch")
    public SuffixArrayServiceResponse requestLcsSearch(@RequestBody LongestCommonSubstringSearchRequest request) {
        SuffixArrayService service = new SuffixArrayService();
        SuffixArrayServiceResponse response = service.longestCommonSubstringSearch(request);
        
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/version")
    public String requestVersion() {
        return "current version is 1.0";
    }
}
