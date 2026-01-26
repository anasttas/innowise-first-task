package org.kharlamova.task.parser.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayParserImplTest {
    private ArrayParserImpl parser;

    @BeforeEach
    void setUp() {
        parser = new ArrayParserImpl();
    }

    @Test
    void shouldParseSimpleNumbers() {
        String line = "1 2 3 4 5";
        int[] expected = {1, 2, 3, 4, 5};

        int[] result = parser.parse(line);

        assertArrayEquals(expected, result);
    }

    @Test
    void shouldParseNumbersWithCommasAndSemicolons() {
        String line = "1,2; 3 -4 5";
        int[] expected = {1, 2, 3, -4, 5};

        int[] result = parser.parse(line);

        assertArrayEquals(expected, result);
    }

    @Test
    void shouldParseNegativeNumbers() {
        String line = "-1 -2 -3";
        int[] expected = {-1, -2, -3};

        int[] result = parser.parse(line);

        assertArrayEquals(expected, result);
    }

    @Test
    void shouldReturnEmptyArrayForEmptyString() {
        String line = "";
        int[] expected = {};

        int[] result = parser.parse(line);

        assertArrayEquals(expected, result);
    }

    @Test
    void shouldReturnEmptyArrayForNullString() {
        String line = null;
        int[] expected = {};

        assertThrows(NullPointerException.class, () -> parser.parse(line));
    }
}
