/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=8175">IsomorphicWords</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class IsomorphicWords implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<String> words = (List<String>) args.get(0);
        long         n     = 0;

        // count number of isomorphic pairs
        for     (int i = 0;     i < words.size(); i++)
            for (int j = i + 1; j < words.size(); j++)
                if (isomorphic(words.get(i), words.get(j)))
                    ++n;

        return n;
    }

    private boolean isomorphic (String a, String b) {
        Map<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < a.length() && i < b.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);

            if (map.containsKey(ca)) {
                if (map.get(ca) != cb)
                    return false;
            } else {
                if (map.containsValue(cb))
                    return false;
                map.put(ca, cb);
            }
        }

        return true;
    }
}
