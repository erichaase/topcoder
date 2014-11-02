/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=4504">PrintScheduler</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class PrintScheduler implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<String>  threads = (List<String>) args.get(0);
        List<String>  slices  = (List<String>) args.get(1);
        StringBuilder output  = new StringBuilder();

        // indices for threads' next character
        List<Integer> iNext = new ArrayList<Integer>();
        for (int i = 0; i < threads.size(); i++)
            iNext.add(0);

        for (String slice : slices) {
            String [] split = slice.split("\\s+", 2);
            int       tid   = Integer.parseInt(split[0]);
            int       time  = Integer.parseInt(split[1]);
            String    str   = threads.get(tid);

            for (int i = 0; i < time; i++) {
                int  j = iNext.get(tid);
                char c = str.charAt(j);

                output.append(c);
                iNext.set(tid, (j + 1) % str.length());
            }
        }

        return output.toString();
    }
}
