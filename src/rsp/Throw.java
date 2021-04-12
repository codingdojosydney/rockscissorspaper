package rsp;

public enum Throw {
    PAPER, SCISSORS, ROCK;

    public boolean beats(Throw aThrow) {
        switch (aThrow) {
            case PAPER:
                return SCISSORS.equals(this);
            case ROCK:
                return PAPER.equals(this);
            case SCISSORS:
                return ROCK.equals(this);
        }
        return false;
    }
}
