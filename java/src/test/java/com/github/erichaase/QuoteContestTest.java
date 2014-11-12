package com.github.erichaase;

import org.junit.Test;

public class QuoteContestTest extends TopCoderTest {
    @Test
    public void test () {
        super.test(new QuoteContest(), "/QuoteContestTest.json");
    }
}
