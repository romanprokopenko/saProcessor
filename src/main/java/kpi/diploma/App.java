package kpi.diploma;

import kpi.diploma.suffixarray.SuffixArray;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] arg) {

        if (arg.length > 0) {
            SuffixArray suffixArray = new SuffixArray(arg[0]);
            System.out.println(suffixArray.getSuffixArray());
        }
    }
}
