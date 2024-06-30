package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballTest {

    Baseball baseball = new Baseball();

    int[] answer = {1, 2, 3};

    @DisplayName("0스트라이크 3볼")
    @Test
    void jude1() {
        baseball.answer = answer;
        int[] input = new int[]{3, 1, 2};
        assertThat(baseball.judge(input).equals(new JudgmentData(0, 3))).isTrue();
    }

    @DisplayName("3스트라이크 0볼")
    @Test
    void jude2() {
        baseball.answer = answer;
        int[] input = new int[]{1, 2, 3};
        assertThat(baseball.judge(input).equals(new JudgmentData(3, 0))).isTrue();
    }

    @DisplayName("포볼 : 0스트라이크 0볼")
    @Test
    void jude4() {
        baseball.answer = answer;
        int[] input = new int[]{4, 5, 6};
        assertThat(baseball.judge(input).equals(new JudgmentData(0, 0))).isTrue();
    }

    @DisplayName("3 > 스트라이크 > 0 && 3 > 볼 > 0")
    @Test
    void jude5() {
        baseball.answer = answer;
        int[] input = new int[]{1, 3, 4};
        assertThat(baseball.judge(input).equals(new JudgmentData(1, 1))).isTrue();
    }

    @DisplayName("조건에 맞지 않은 입력이 들어왔을 경우")
    @Test
    void strangeInput() {
        baseball.answer = answer;
        assertThatThrownBy(() -> {
            baseball.judge(baseball.makeGuessArray("2 + 1 / 0 + 4"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}