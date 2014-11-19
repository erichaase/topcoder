/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=6557">ReverseSums</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class ReverseSums implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        long x = (Long) args.get(0);

        // easiest solution involves converting number to string and back
        // more interesting solution is to calculate digits and reverse

        // calculate number of digits in x
        int iMax = 0;
        while (Math.pow(10, iMax + 1) <= x)
            ++iMax;

        // reverse digits of x
        long y = x; // preserve original x value
        long r = 0; // reversed value
        for (int i = iMax; i >= 0; i--) {
            long py = (long) Math.pow(10, i);
            long pr = (long) Math.pow(10, iMax - i);
            long d  = y / py;

            r += d * pr;
            y  = y % py;
        }

        return r + x;
    }
}
