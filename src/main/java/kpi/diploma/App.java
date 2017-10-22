package kpi.diploma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] arg) {

//        String input = "abcabc\u001Fbc";
//        SuffixArray suffixArray = new SuffixArray(input);
//        for (int i = 0; i < suffixArray.getSuffixArray().size(); i++) {
//            System.out.println("-----------------");
//            System.out.println(suffixArray.getSuffixArray().get(i));
//            System.out.println("lcp: " + suffixArray.getLcpArray().get(i));
//            System.out.println(input.substring(suffixArray.getSuffixArray().get(i)));
//        }
//        LongestCommonSubstringSearchRequest request = new LongestCommonSubstringSearchRequest("привет петуч", "петучила");
//        SuffixArrayService service = new SuffixArrayService();
//        SuffixArrayServiceResponse response = service.longestCommonSubstringSearch(request);
//        System.out.println(response);

//        SingleSubstringSearchRequest request = new SingleSubstringSearchRequest("banana", "e");
//        SuffixArrayService service = new SuffixArrayService();
//        SuffixArrayServiceResponse response = service.singleSubstringSearch(request);
//        System.out.println(response);
        SpringApplication.run(App.class, arg);
    }
}
