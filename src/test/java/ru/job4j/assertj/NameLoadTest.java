package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseWhenNoNames() {
        NameLoad nm = new NameLoad();
        String[] str = new String[0];
        assertThatThrownBy(() -> nm.parse(str)).isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void checkValidateWhenNoEqualsChar() {
        NameLoad nm = new NameLoad();
        String str = "huy huy huyeeee";
        assertThatThrownBy(() -> nm.parse(str)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(str);
    }

    @Test
    void checkWhenNoKey() {
        NameLoad nm = new NameLoad();
        String str = "=huy huy huyeeee";
        assertThatThrownBy(() -> nm.parse(str)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(str);
    }

    @Test
    void checkWhenNoValue() {
        NameLoad nm = new NameLoad();
        String str = "huy huy huyeeee=";
        assertThatThrownBy(() -> nm.parse(str)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(str);
    }
}