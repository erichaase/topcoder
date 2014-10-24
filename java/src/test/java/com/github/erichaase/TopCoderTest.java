package com.github.erichaase;

import java.io.*;
import org.apache.commons.io.FileUtils;

import static org.junit.Assert.*;

import org.json.simple.*;

public class TopCoderTest {
    public void test (TopCoderProblem problem, String filename) {
        File   file = new File(this.getClass().getResource(filename).getFile());
        String json = "";

        try {
            json = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            fail(e.toString());
        }

        for (Object testcase : (JSONArray) JSONValue.parse(json)) {
            JSONArray args     = (JSONArray) testcase;
            Object    expected = args.remove(args.size() - 1);

            Object result = problem.solution(args);
            assertEquals(expected, result);
        }
    }
}
