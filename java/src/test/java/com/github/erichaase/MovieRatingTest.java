package com.github.erichaase;

import org.junit.Test;

public class MovieRatingTest extends TopCoderTest {
    @Test
    public void test () {
        super.test(new MovieRating(), "/MovieRatingTest.json");
    }
}
