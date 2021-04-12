package rsp;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class RockScissorsPaperUnitTest {
    private RockScissorsPaperUnitTest.TwoPlayerRsp twoPlayerRsp;

    @Before
    public void setUp() throws Exception {
        twoPlayerRsp = new TwoPlayerRsp();
    }

    private enum Result {
        PLAYER_ONE, PLAYER_TWO, NOBODY;
    }

    @Test
    public void rockShouldBeatScissor() {
        assertThat(twoPlayerRsp.twoPlayerRsp(Throw.ROCK, Throw.SCISSORS), equalTo(Result.PLAYER_ONE));
    }

    @Test
    public void paperShouldBeatRock() {
        assertThat(twoPlayerRsp.twoPlayerRsp(Throw.ROCK, Throw.PAPER), equalTo(Result.PLAYER_TWO));
    }

    @Test
    public void rockShouldDrawAgainstRock() {
        assertThat(twoPlayerRsp.twoPlayerRsp(Throw.ROCK, Throw.ROCK), equalTo(Result.NOBODY));
    }

    @Test
    public void scissorsShouldBeatPaper() {
        assertThat(twoPlayerRsp.twoPlayerRsp(Throw.SCISSORS, Throw.PAPER), equalTo(Result.PLAYER_ONE));
    }

    private static class TwoPlayerRsp {
        public TwoPlayerRsp() {
        }

        private Result twoPlayerRsp(Throw playerOneThrow, Throw playerTwoThrow) {
            Result result = Result.NOBODY;
            if (playerOneThrow.beats(playerTwoThrow)) {
                result = Result.PLAYER_ONE;
            } else if (playerTwoThrow.beats(playerOneThrow)) {
                result = Result.PLAYER_TWO;
            }
            return result;
        }
    }
}
