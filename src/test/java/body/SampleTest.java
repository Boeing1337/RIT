package body;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SampleTest {

    @Test
    void testToString() {
        Sample sample = new Sample();
        String s = sample.toString();
        Assertions.assertEquals("class name", s, "Должно возвращаться имя класса");
    }

    @Test
    void testToStringSDFGdsg() {
        Sample sample = new Sample();
        String s = sample.toString();
        Assertions.assertEquals("class name", s, "Должно возвращаться имя класса");
    }
}