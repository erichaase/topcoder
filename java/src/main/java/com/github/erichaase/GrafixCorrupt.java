/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=2997">GrafixCorrupt</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class GrafixCorrupt implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<String> dictionary = (List<String>) args.get(0);
        String       candidate  = (String)       args.get(1);
        long         index;

        // calculate similarity for each dictionary word
        List<Integer> similar = new ArrayList<Integer>();

        for (int i = 0; i < dictionary.size(); i++) {
            String word = dictionary.get(i);
            int    n    = 0;

            for (int j = 0; j < candidate.length(); j++)
                if (candidate.charAt(j) == word.charAt(j))
                    ++n;

            similar.add(n);
        }

        // find maximum index
        int maxIndex = 0;

        for (int i = 1; i < similar.size(); i++)
            if (similar.get(i) > similar.get(maxIndex))
                maxIndex = i;

        if (similar.get(maxIndex) == 0)
            index = -1;
        else
            index = maxIndex;

        return index;
    }
}
