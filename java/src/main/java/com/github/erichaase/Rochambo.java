/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=1810">Rochambo</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class Rochambo implements TopCoderProblem {
    private static final Map<Character, Character> beats;
    static {
        beats = new HashMap<Character, Character>();
        beats.put('R', 'P');
        beats.put('P', 'S');
        beats.put('S', 'R');
    }

    private static final Map<String, Character> next;
    static {
        next = new HashMap<String, Character>();
        next.put("RR", 'R');
        next.put("PP", 'P');
        next.put("SS", 'S');
        next.put("PS", 'R');
        next.put("SP", 'R');
        next.put("RS", 'P');
        next.put("SR", 'P');
        next.put("RP", 'S');
        next.put("PR", 'S');
    }

    public Object solution (JSONArray args) {
        // input / output
        String opponent = (String) args.get(0);
        long   n        = 0;

        // calculate n
        for (int i = 0; i < opponent.length(); i++) {
            char mine, theirs = opponent.charAt(i);

            if (i < 2)
                mine = 'R';
            else {
                String first  = Character.toString(opponent.charAt(i-2));
                String second = Character.toString(opponent.charAt(i-1));
                       mine   = beats.get(next.get(first + second));
            }

            if (beats.get(theirs) == mine)
                ++n;
        }

        return n;
    }
}
