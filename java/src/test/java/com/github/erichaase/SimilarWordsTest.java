package com.github.erichaase;

import org.junit.Test;

public class SimilarWordsTest extends TopCoderTest {
    @Test
    public void test () {
        super.test(new SimilarWords(), "/SimilarWordsTest.json");
    }
}
