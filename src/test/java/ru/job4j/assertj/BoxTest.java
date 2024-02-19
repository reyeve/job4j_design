package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void whenNumberOfVertixesIs8() {
        Box box = new Box(8, 20);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isEqualTo(8);
    }

    @Test
    void whenExist() {
        Box box = new Box(8, 20);
        boolean rls = box.isExist();
        assertThat(rls).isTrue();
    }

    @Test
    void whenDontExist() {
        Box box = new Box(5000, -120);
        boolean rls = box.isExist();
        assertThat(rls).isFalse();
    }
}