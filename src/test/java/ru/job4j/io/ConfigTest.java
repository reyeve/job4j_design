package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenIllegalArgument() {
        String path = "./data/except.properties";
        Config config = new Config(path);
        boolean check = false;
        try {
            config.load();
        } catch ( IllegalArgumentException e) {
            check = true;
        }
        assertThat(check).isTrue();
    }
}