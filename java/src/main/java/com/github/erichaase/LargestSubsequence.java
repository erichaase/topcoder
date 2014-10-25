/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=11471">LargestSubsequence</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class LargestSubsequence implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        String s = (String) args.get(0);
        String o = "";

        // build output o string
        while (s.length() > 0) {
            // find index of largest char
            int iMax = 0;
            for (int i = 1; i < s.length(); i++)
                if (s.charAt(i) > s.charAt(iMax))
                    iMax = i;

            o += s.charAt(iMax);
            s  = s.substring(iMax + 1);
        }

        return o;
    }
}
