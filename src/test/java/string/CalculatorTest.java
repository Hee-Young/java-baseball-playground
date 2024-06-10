package string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10",
            "5 * 2 + 9:19",
            "2 + 6 / 2 * 11:44",
            "4 - 3 + 8 * 10:90",
            "10 / 5 + 2 / 4:1",
            "0 - 2:-2"
    }, delimiter = ':')
    void normalCase(String input, int expected) {
        assertEquals(calculator.calculate(input), expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+ 8 / 4 * 21",
            "1 +5 + 2 / 4"
    })
    void strangeOperandsException(String input) {
        assertThatThrownBy(() -> {
            calculator.calculate(input);
        }).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2/1+4",
            "",
            "  ",
            "1 h 2"
    })
    void strangeInputException(String input){
        assertThatThrownBy(() -> {
            calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void divideZero() {
        assertThatThrownBy(() -> {
            calculator.calculate("2 + 1 / 0 + 4");
        }).isInstanceOf(ArithmeticException.class);
    }
}
