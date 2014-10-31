/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=7702">DriveFailures</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class DriveFailures implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<Double> probsIn  = (List<Double>) args.get(0);
        List<Double> probsOut = new ArrayList<Double>();

        // get permutations of all possibilities, categorize/index by # of failures
        List<List<List<Boolean>>> perms = getPermutations(probsIn.size());

        // calculate probabilities
        for (int i = 0; i < perms.size(); i++) {
            List<List<Boolean>> perm = perms.get(i);
            double total = 0;

            for (List<Boolean> p : perm) {
                double prob = 1;
                for (int j = 0; j < p.size(); j++) {
                    if (p.get(j)) {
                        prob *= probsIn.get(j);
                    } else {
                        prob *= 1 - probsIn.get(j);
                    }
                }
                total += prob;
            }

            probsOut.add(total);
        }

        return probsOut;
    }

    private List<List<List<Boolean>>> getPermutations (int size) {
        // create and initialize permutations
        List<List<List<Boolean>>> p = new ArrayList<List<List<Boolean>>>();
        for (int i = 0; i < size + 1; i++)
            p.add(new ArrayList<List<Boolean>>());

        // setup permutations, index == # of failures
        for (List<Boolean> l : permutation(size)) {
            int nTrue = 0;
            for (int i = 0; i < l.size(); i++)
                if (l.get(i))
                    ++nTrue;
            p.get(nTrue).add(l);
        }

        return p;
    }

    private List<List<Boolean>> permutation (int n) {
        if (n == 1) {
            List<List<Boolean>> l = new ArrayList<List<Boolean>>();
            List<Boolean>       t = new ArrayList<Boolean>();
            List<Boolean>       f = new ArrayList<Boolean>();

            t.add(true);
            f.add(false);
            l.add(t);
            l.add(f);

            return l;
        } else {
            List<List<Boolean>> l = new ArrayList<List<Boolean>>();
            List<List<Boolean>> t = permutation(n-1);
            List<List<Boolean>> f = permutation(n-1);

            for (List<Boolean> e : t) {
                e.add(0, true);
                l.add(e);
            }
            for (List<Boolean> e : f) {
                e.add(0, false);
                l.add(e);
            }

            return l;
        }
    }
}
