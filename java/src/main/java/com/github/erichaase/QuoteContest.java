/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=7594">QuoteContest</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class QuoteContest implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<String> quotes = (List<String>) args.get(0);

        int iWinner = 0, sumWinner = 0;
        for (int i = 0; i < quotes.size(); i++) {
            String [] splitCur = quotes.get(i).split(" ");
            int       sumCur   = Integer.parseInt(splitCur[0]) + Integer.parseInt(splitCur[1]);

            if (sumCur > sumWinner) {
                iWinner   = i;
                sumWinner = sumCur;
            }
        }

        return quotes.get(iWinner).split(" ")[2];
    }
}
