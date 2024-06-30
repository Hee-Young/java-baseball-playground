package baseball;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String input() {
        return scanner.nextLine();
    }

    public boolean gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputValue = input();

        if (inputValue.equals("1")) {
            return true;
        } else if (inputValue.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("올바르지 않은 입력입니다.");
    }
}
