/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=2891">RedSquare</a>
 */

package com.github.erichaase;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import org.json.simple.*;

public class RedSquare implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        long       maxRank = (Long)       args.get(0);
        long       maxFile = (Long)       args.get(1);
        List<Long> rank    = (List<Long>) args.get(2);
        List<Long> file    = (List<Long>) args.get(3);

        // create Set of all red squares
        Set<Entry<Long, Long>> reds = new HashSet<Entry<Long, Long>>();

        // populate Set starting with bottom-right black square
        boolean evenColumn = true;
        for (long x = maxFile; x > 0; x--) {
            for (long y = 1; y <= maxRank; y++) {
                Entry<Long, Long> xy = new SimpleEntry<Long, Long>(x, y);
                if      ((evenColumn)  && (y % 2 == 0))
                    reds.add(xy);
                else if ((!evenColumn) && (y % 2 == 1))
                    reds.add(xy);
            }
            evenColumn = ! evenColumn;
        }

        // Iterate through given squares and remove from Set
        for (int i = 0; (i < rank.size()) && (i < file.size()); i++) {
            Entry<Long, Long> xy = new SimpleEntry<Long, Long>(file.get(i), rank.get(i));
            if (reds.contains(xy))
                reds.remove(xy);
        }

        return (long) reds.size();
    }
}
