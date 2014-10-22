package com.github.erichaase;

import java.io.*;
import org.apache.commons.io.FileUtils;

import        org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.json.simple.*;
import org.json.simple.parser.ParseException;

public class HuffmanDecodingTest {
    private static final String TEST_DATA_PATH = "/HuffmanDecodingTest.json";

    @Test
    public void test() throws IOException, ParseException {
        File   f = new File(this.getClass().getResource(TEST_DATA_PATH).getFile());
        String s = FileUtils.readFileToString(f, "UTF-8");

        for (Object testcase : (JSONArray) JSONValue.parse(s)) {
            JSONArray args     = (JSONArray) testcase;
            Object    expected = args.remove(args.size() - 1);

            Object result = HuffmanDecoding.solution(args);
            assertEquals(expected, result);
        }
    }
}
