/**
 * @see <a href="http://community.topcoder.com/stat?c=problem_statement&pm=6477">HuffmanDecoding</a>
 */

package com.github.erichaase;

import java.util.*;
import org.json.simple.*;

public class HuffmanDecoding implements TopCoderProblem {
    public Object solution (JSONArray args) {
        // input / output
        String    encodedIn = (String)    args.get(0);
        JSONArray dictIn    = (JSONArray) args.get(1);
        String    decoded   = "";

        // intermediate data structures
        List<String>            encoded = new ArrayList<String>();
        HashMap<String, String> dict    = new HashMap<String, String>();

        // build List of encoded string chars
        for (int i = 0; i < encodedIn.length(); i++) {
            String c = Character.toString(encodedIn.charAt(i));
            encoded.add(c);
        }

        // build HashMap dictionary
        char c = 'A'; int i = 0;
        for (Object key : dictIn) {
            dict.put((String) key, Character.toString(c));
            ++c; ++i;
        }

        // build decoded string
        while (encoded.size() != 0) {
            String cur = encoded.remove(0);
            while (! dict.containsKey(cur))
                cur += encoded.remove(0);
            decoded += dict.get(cur);
        }

        return decoded;
    }
}
