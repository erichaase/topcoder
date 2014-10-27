/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=8118">MovieRating</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class MovieRating implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<Long> marks     = (List<Long>) args.get(0);
        Long       lowCount  = (Long)       args.get(1);
        Long       highCount = (Long)       args.get(2);

        Collections.sort(marks);

        for (int i = 0; i < lowCount; i++)
            marks.remove(0);
        for (int i = 0; i < highCount; i++)
            marks.remove(marks.size() - 1);

        double sum = 0;
        for (Long mark : marks)
            sum += mark;

        return sum / marks.size();
    }
}
