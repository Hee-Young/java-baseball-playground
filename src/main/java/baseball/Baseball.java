package baseball;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Baseball {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    int[] answer = new int[3];
    private boolean isplayingGame = true;

    public void startGame() {
        while (isplayingGame) {
            startInning();
        }
    }

    public void startInning() {
        boolean isInningDone = false;

        makeAnswer();

        while (!isInningDone) {
            System.out.print("숫자를 입력해 주세요 : ");
            String input = inputView.input();

            JudgmentData judgment = judge(makeGuessArray(input));

            outputView.result(judgment.getStrike(), judgment.getBall());

            isInningDone = judgment.check3Strike();
        }
        isplayingGame = inputView.gameOver();
    }

    private void makeAnswer() {
        Set<Integer> integers = new HashSet<>();

        IntStream.rangeClosed(0, answer.length - 1).forEach(i -> {
            int random = (int) (Math.random() * 9) + 1;
            integers.add(random);
        });
        answer = integers.stream()
            .mapToInt(Number::intValue)
            .toArray();

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

    public int[] makeGuessArray(String input) {
        int[] values = new int[3];

        if (input.length() != 3) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }

        for (int i = 0; i < input.length(); i++) {
            values[i] = input.charAt(i) - '0';
        }

        return values;
    }

    public JudgmentData judge(int[] input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            strike += countStrike(answer[i], input[i]);
            ball += countBall(input[i], answer[(i + 1) % 3], answer[(i + 2) % 3]);
        }

        return new JudgmentData(strike, ball);
    }

    private int countStrike(int answer, int input) { // 동일한 기능 필요할 때
        if (answer == input) {
            return 1;
        }
        return 0;
    }

    private int countBall(int input, int answer1, int answer2) {
        if (input == answer1 || input == answer2) { // 같은 숫자 다른 자리
            return 1;
        }
        return 0;
    }
}
