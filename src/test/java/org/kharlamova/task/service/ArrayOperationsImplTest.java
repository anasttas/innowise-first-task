package org.kharlamova.task.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.exception.CustomArrayException;
import org.kharlamova.task.service.impl.ArrayOperationsImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayOperationsImplTest {
    private ArrayOperationsImpl arrayService;
    private IntArrayEntity arrayEntity;

    @BeforeEach
    void setUp() {
        arrayService = new ArrayOperationsImpl();
        arrayEntity = new IntArrayEntity(1L, new int[]{5, 2, 9, -1, 7});
    }

    @Test
    void testMax() throws CustomArrayException {
        int max = arrayService.max(arrayEntity);
        assertEquals(9, max, "Max value should be 9");
    }

    @Test
    void testMin() throws CustomArrayException {
        int min = arrayService.min(arrayEntity);
        assertEquals(-1, min, "Min value should be -1");
    }

    @Test
    void testSumValues() throws CustomArrayException {
        double sum = arrayService.sumValues(arrayEntity);
        assertEquals(22, sum, "Sum should be 22");
    }

    @Test
    void testMaxWithEmptyArray() {
        IntArrayEntity emptyArray = new IntArrayEntity(2L, new int[]{});
        assertThrows(CustomArrayException.class, () -> arrayService.max(emptyArray));
    }

    @Test
    void testMinWithEmptyArray() {
        IntArrayEntity emptyArray = new IntArrayEntity(2L, new int[]{});
        assertThrows(CustomArrayException.class, () -> arrayService.min(emptyArray));
    }

    @Test
    void testSumWithEmptyArray() throws CustomArrayException {
        IntArrayEntity emptyArray = new IntArrayEntity(2L, new int[]{});
        double sum = arrayService.sumValues(emptyArray);
        assertEquals(0, sum, "Sum of empty array should be 0");
    }
}
