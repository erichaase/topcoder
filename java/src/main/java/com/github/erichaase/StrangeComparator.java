/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=10010">StrangeComparator</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class StrangeComparator implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<String> a      = (List<String>) args.get(0);
        List<String> b      = (List<String>) args.get(1);
        List<String> output = new ArrayList<String>();

        for (int i = 0; i < a.size(); i++) {
            String x = a.get(i);
            String y = b.get(i);

            if (x.length() != y.length()) {
                output.add("No");
                continue;
            }

            // calculate number of character differences
            int j, ndiff = 0;

            for (j = 0; (j < x.length()) && (j < y.length()); j++)
                if (x.charAt(j) != y.charAt(j))
                    ++ndiff;

            if (j < x.length())
                ndiff += (j - x.length());
            if (j < y.length())
                ndiff += (j - y.length());

            if (ndiff <= 1)
                output.add("Yes");
            else
                output.add("No");
        }

        return output;
    }
}
