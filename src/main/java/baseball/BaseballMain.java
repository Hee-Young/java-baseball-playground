package baseball;

import java.util.Scanner;

public class BaseballMain {

    Baseball baseball = new Baseball();
    InputView inputView = new InputView();

    boolean isplaying = true;

    public static void main(String[] args) {
        BaseballMain baseball = new BaseballMain();

        baseball.startGame();
    }

    private void startGame() {
        while (isplaying) {
            startInning();
        }
    }

    public void startInning() {
        boolean isDone = false;

        baseball.makeAnswer();

        while (!isDone) {
            System.out.print("숫자를 입력해 주세요 : ");
            String input = inputView.input();

            JudgmentData judgment = baseball.judge(baseball.makeGuessArray(input));

            isDone = judgment.check3Strike()
;        }
        isplaying = inputView.gameOver();
    }
}