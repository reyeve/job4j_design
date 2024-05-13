package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class AnalysisTest {

    @Test
    void drop(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.log").toFile();
        try (PrintWriter output = new PrintWriter(source)) {
            output.println("100 10:30:20");
            output.println("200 10:40:00");
            output.println("400 10:51:00");
            output.println("500 10:55:00");
            output.println("100 11:00:00");
        }
        File target  = tempDir.resolve("targetTest.csv").toFile();
        Analysis test = new Analysis();
        test.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::append);
        }
        assertThat("10:51:00;11:00:00;").hasToString(result.toString());
    }
}