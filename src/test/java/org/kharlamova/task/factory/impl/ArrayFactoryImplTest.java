package org.kharlamova.task.factory.impl;

import org.junit.jupiter.api.Test;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.factory.ArrayFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayFactoryImplTest {
    @Test
    void testCreateArray() {
        ArrayFactory factory = new ArrayFactoryImpl();
        int[] sourceArray = {1, 2, 3};

        IntArrayEntity result = factory.createArray(1L, sourceArray);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertArrayEquals(sourceArray, result.getArray());
    }

    @Test
    void testArrayIsCloned() {
        ArrayFactory factory = new ArrayFactoryImpl();
        int[] sourceArray = {5, 10, 15};

        IntArrayEntity result = factory.createArray(2L, sourceArray);

        sourceArray[0] = 999;

        assertNotEquals(999, result.getArray()[0]);
    }
}
