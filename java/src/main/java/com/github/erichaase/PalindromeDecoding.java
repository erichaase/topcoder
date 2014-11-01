/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=6767">PalindromeDecoding</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class PalindromeDecoding implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        StringBuilder code     = new StringBuilder((String) args.get(0));
        List<Long>    position = (List<Long>) args.get(1);
        List<Long>    length   = (List<Long>) args.get(2);

        for (int i = 0; i < position.size(); i++) {
            int p = position.get(i).intValue();
            int l = length.get(i).intValue();

            String substr = code.substring(p, p + l);
            String substrRev = "";
            for (int j = substr.length() - 1; j >= 0; j--)
                substrRev += substr.charAt(j);

            code.insert(p + l, substrRev);
        }

        return code.toString();
    }
}
