/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=8114">ComplementaryDNAChains</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class ComplementaryDNAChains {
    public static Object solution (JSONArray args) {
        // input / output
        String first  = (String) args.get(0);
        String second = (String) args.get(1);
        long   n      = 0;

        for (int i = 0; i < first.length(); i++) {
            char a = first.charAt(i);
            char b = second.charAt(i);

            if      (((a == 'A') && (b == 'T')) || ((a == 'T') && (b == 'A')))
                continue;
            else if (((a == 'C') && (b == 'G')) || ((a == 'G') && (b == 'C')))
                continue;
            else
                ++n;
        }

        return n;
    }
}
