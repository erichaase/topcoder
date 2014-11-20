/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=10874">Islands</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class Islands implements TopCoderProblem {
    private List<String> kingdom;

    public Object solution (JSONArray args) {
        // input / output
             kingdom = (List<String>) args.get(0);
        long n       = 0;

        // sum the following values for each element:
        // left, bottom-left, bottom-right
        for     (int i = 0; i < kingdom.size();          i++)
            for (int j = 0; j < kingdom.get(i).length(); j++)
                n += beaches(i, j);

        return n;
    }

    private long beaches (int i, int j) {
        return beachLeft(i, j)       +
               beachBottomLeft(i, j) +
               beachBottomRight(i, j);
    }

    private long beachLeft (int i, int j) {
        if (j == 0)
            return 0;

        char cur  = kingdom.get(i).charAt(j);
        char left = kingdom.get(i).charAt(j-1);

        if (cur != left)
            return 1;
        else
            return 0;
    }

    private long beachBottomLeft (int i, int j) {
        if (i == kingdom.size() - 1) // bottom row
            return 0;

        char cur = kingdom.get(i).charAt(j);
        char bLeft;

        if (i % 2 == 0) { // row is even
            if (j == 0)
                return 0;
            bLeft = kingdom.get(i+1).charAt(j-1);
        } else { // row is odd
            bLeft = kingdom.get(i+1).charAt(j);
        }

        if (cur != bLeft)
            return 1;
        else
            return 0;
    }

    private long beachBottomRight (int i, int j) {
        if (i == kingdom.size() - 1) // bottom row
            return 0;

        char cur = kingdom.get(i).charAt(j);
        char bRight;

        if (i % 2 == 0) { // row is even
            bRight = kingdom.get(i+1).charAt(j);
        } else { // row is odd
            if (j == kingdom.get(i+1).length() - 1)
                return 0;
            bRight = kingdom.get(i+1).charAt(j+1);
        }

        if (cur != bRight)
            return 1;
        else
            return 0;
    }
}
