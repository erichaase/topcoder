/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=9914">DeckRearranging</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class DeckRearranging implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        String        deckOld = (String)     args.get(0);
        List<Long>    above   = (List<Long>) args.get(1);
        StringBuilder deckNew = new StringBuilder();

        for (int i = 0; i < deckOld.length(); i++) {
            char c = deckOld.charAt(i);
            int  j = above.get(i).intValue();
            deckNew.insert(j, c);
        }

        return deckNew.toString();
    }
}
