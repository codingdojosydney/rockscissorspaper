package rsp;

import org.junit.Test;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.Description;

public class ThrowTest {
    @Test
    public void scissorsIsGreaterThanPaper() {
        org.hamcrest.MatcherAssert.assertThat(Throw.SCISSORS, beats(Throw.PAPER));
    }

    @Test
    public void paperIsGreaterThanRock() {
        org.hamcrest.MatcherAssert.assertThat(Throw.PAPER, beats(Throw.ROCK));
    }

    @Test
    public void rockIsGreaterThanScissors() {
        org.hamcrest.MatcherAssert.assertThat(Throw.ROCK, beats(Throw.SCISSORS));
    }

    @Test
    public void shouldNotCreateEnumsFromNumbers() {
        
    }

    private Matcher<Throw> beats(final Throw expected) {
        return new TypeSafeMatcher<Throw>() {
            public boolean matchesSafely(Throw aThrow) {
                return aThrow.beats(expected);
            }

            public void describeTo(Description description) {
                description.appendText("beats");
                description.appendValue(expected);
            }
        };
    }
}
