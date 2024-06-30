package baseball;

import java.util.Objects;

public class JudgmentData {

    private int strike;
    private int ball;

    JudgmentData(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    boolean check3Strike(){
        if(strike == 3){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JudgmentData that = (JudgmentData) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
