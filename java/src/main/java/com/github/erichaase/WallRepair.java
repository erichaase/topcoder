/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=6502">WallRepair</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class WallRepair implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<String> rows = (List<String>) args.get(0);
        long         n    = 0;

        for (int i = 0; i < rows.size(); i++) {
            String row = rows.get(i);

            for (int j = 0; j < row.length(); j++) {
                char brick = row.charAt(j);

                if (brick == 'X') {
                    for (int k = i + 1; k < rows.size(); k++) {
                        String rowUnder = rows.get(k);

                        if (rowUnder.charAt(j) == '.') {
                            StringBuilder rowReplace = new StringBuilder(rowUnder);
                            rowReplace.setCharAt(j, 'X');
                            rows.set(k, rowReplace.toString());
                            ++n;
                        }
                    }
                }
            }
        }

        return n;
    }
}
