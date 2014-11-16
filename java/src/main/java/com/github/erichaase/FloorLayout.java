/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=8398">FloorLayout</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class FloorLayout implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<String> layout = (List<String>) args.get(0);
        long         n      = 0;

        // represent floor as two-dimensional character array
        char [][] floor = new char [layout.size()][layout.get(0).length()];
        for     (int i = 0; i < layout.size();          i++)
            for (int j = 0; j < layout.get(i).length(); j++)
                floor[i][j] = layout.get(i).charAt(j);

        // iterate through floor characters
        for     (int i = 0; i < floor.length;    i++) {
            for (int j = 0; j < floor[i].length; j++) {
                if (floor[i][j] == '-') { // Process horizontal board
                    for (int k = j - 1; (k >= 0) && (floor[i][k] == '-'); k--)
                        floor[i][k] = 'x'; // Mark units left of current unit
                    for (int k = j + 1; (k < floor[i].length) && (floor[i][k] == '-'); k++)
                        floor[i][k] = 'x'; // Mark units right of current unit
                    ++n;
                } else if (floor[i][j] == '|') { // Process vertical board
                    for (int k = i - 1; (k >= 0) && (floor[k][j] == '|'); k--)
                        floor[k][j] = 'x'; // Mark units above current unit
                    for (int k = i + 1; (k < floor.length) && (floor[k][j] == '|'); k++)
                        floor[k][j] = 'x'; // Mark units below current unit
                    ++n;
                }
            }
        }

        return n;
    }
}
