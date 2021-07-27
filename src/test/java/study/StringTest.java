package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] twoElements = "1,2".split(",");
        assertThat(twoElements).containsExactly("1", "2");

        String[] oneElement = "1".split(",");
        assertThat(oneElement).contains("1");
    }

    @Test
    void substring() {
        String target = "(1,2)";
        String actual = target.substring(1, target.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("throwExceptionWhenCharAtOutOfBounds")
    void charAt() {
        int targetIdx = 4;
        assertThatThrownBy(() -> {
            char actual = "abc".charAt(targetIdx);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + targetIdx);
    }

}
