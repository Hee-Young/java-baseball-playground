package baseball;

public class OutputView {

    public void result(int strike, int ball) {

        if (strike == 3 && ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (ball > 0 && strike > 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
            return;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("포볼");
        }
    }
}
