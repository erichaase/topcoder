package com.github.erichaase;

import org.junit.Test;

public class PrintSchedulerTest extends TopCoderTest {
    @Test
    public void test () {
        super.test(new PrintScheduler(), "/PrintSchedulerTest.json");
    }
}
