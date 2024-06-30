package baseball;

import java.util.Set;

public class Baseball {

    OutputView outputView = new OutputView();

    int[] answer = new int[3];

    // 중복 없이 난수 생성하는 법..!!!
    public void makeAnswer() {
        answer[0] = (int) (Math.random() * 9) + 1;
        for (int i = 1; i < answer.length; i++) {
            answer[i] = (int) (Math.random() * 9) + 1;
            i -= countStrike(answer[i], answer[i - 1]);
            if (i == 2) {
                i -= countStrike(answer[i], answer[i - 2]);
            }
        }
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

        outputView.result(strike, ball);
        return new JudgmentData(strike, ball);
    }

    public int countStrike(int number1, int number2) { // 동일한 기능 필요할 때
        if (number1 == number2) {
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
