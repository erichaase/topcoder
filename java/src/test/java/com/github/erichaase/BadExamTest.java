package com.github.erichaase;

import org.junit.Test;

public class BadExamTest extends TopCoderTest {
    @Test
    public void test () {
        super.test(new BadExam(), "/BadExamTest.json");
    }
}
