/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=11234">FoxMakingDice</a>
 */

package com.github.erichaase;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import org.json.simple.*;

public class FoxMakingDice implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        long n     = (Long) args.get(0);
        long k     = (Long) args.get(1);
        long nDice = 0;

        // find all pairs of integers that equal a particular sum
        Map<Integer, List<Entry<Integer, Integer>>> sumPairs = new HashMap<Integer, List<Entry<Integer, Integer>>>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (i + j >= k) {
                    int sum = i + j;

                    if (! sumPairs.containsKey(sum))
                        sumPairs.put(sum, new ArrayList<Entry<Integer, Integer>>());

                    sumPairs.get(sum).add(new SimpleEntry<Integer, Integer>(i, j));
                }
            }
        }

        // calculate how many dice we can make for each sum
        for (int sum : sumPairs.keySet())
            // for each pair, we want to calculate the permutation for the remaining two pairs of sides
            for (int i = sumPairs.get(sum).size() - 1; i > 1; i--)
                nDice += i * (i - 1);

        return nDice;
    }
}
