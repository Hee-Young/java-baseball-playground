package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        assertThat("abc".replace("b", "d")).isEqualTo("adc");
    }

    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() 은 문자열의 길이보다 큰 인수를 받을 수 없다.")
    void exception() {
        assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 5");
    }
}
