package com.github.erichaase;

import org.junit.Test;

public class StrangeComparatorTest extends TopCoderTest {
    @Test
    public void test () {
        super.test(new StrangeComparator(), "/StrangeComparatorTest.json");
    }
}
