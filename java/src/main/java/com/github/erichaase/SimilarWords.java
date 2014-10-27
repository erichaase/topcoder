/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=8563">SimilarWords</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class SimilarWords implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<String> words = (List<String>) args.get(0);
        long         n     = 0;

        // lowercase words
        for (int i = 0; i < words.size(); i++)
            words.set(i, words.get(i).toLowerCase());

        // calculate largest pair of similar words
        for     (int i = 0;     i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                int s = similarity(words.get(i), words.get(j));
                if (s > n)
                    n = s;
            }
        }

        return n;
    }

    public int similarity (String a, String b) {
        List<Character> x = new ArrayList<Character>();
        List<Character> y = new ArrayList<Character>();
        int             n = 0;

        for (int i = 0; i < a.length(); i++)
            x.add(a.charAt(i));
        for (int i = 0; i < b.length(); i++)
            y.add(b.charAt(i));

        for (char cx : x) {
            for (int i = 0; i < y.size(); i++) {
                if (cx == y.get(i)) {
                    y.remove(i);
                    ++n;
                    break;
                }
            }
        }

        return n;
    }
}
