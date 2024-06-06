package string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @Test
    void example(){
        inputHandling("2 + 3 * 4 / 2");
        assertThat(calculator.input()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "5 * 2 + 9",
            "2 + 6 / 2 * 11",
            "4 - 3 + 8 * 10",
            "10 / 5 + 2 / 4"
    })
    void normalCase(String str){
        inputHandling(str);
        assertThat(calculator.input()).isNotEqualTo(-1);
    }

    @Test
    void strangeCase(){
        inputHandling("// 1 /2+");
        assertThat(calculator.input()).isEqualTo(0);
    }
    @ParameterizedTest
    @ValueSource(strings = {
            "// 1 /2+",
            "2/1+4",
            "+ 8 / 4 * 21",
            "1 +5 + 2 / 4"
    })
    void strangeCase(String str){
        inputHandling(str);
        assertThat(calculator.input()).isNotEqualTo(-1);
    }

    @Test
    void divideZero() {
        inputHandling("2 + 1 / 0 + 4");
        assertThat(calculator.input()).isEqualTo(-1); // 뒤에 + 4 때문에 0이 아니라 4,,
    }

    @Test
    void strangeOperator() {
        inputHandling("2 c 1 / 3 + 4");
        assertThat(calculator.input()).isEqualTo(-1); // 뒤에 + 4 때문에 0이 아니라 4,,
    }
}
