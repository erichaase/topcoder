/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=7342">BadExam</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class BadExam implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        List<Long> marks = (List<Long>) args.get(0);

        // find maximum mark
        double max = 0;
        for (long mark : marks)
            if (mark > max)
                max = mark;

        // sum new calculated marks
        double sum = 0;
        for (long mark : marks)
            sum += mark / max * 100.0;

        // return average
        return sum / marks.size();
    }
}
