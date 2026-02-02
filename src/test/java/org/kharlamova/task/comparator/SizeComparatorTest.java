package org.kharlamova.task.comparator;

import org.junit.jupiter.api.Test;
import org.kharlamova.task.entity.IntArrayEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SizeComparatorTest {
    @Test
    void testCompareBySize() {
        IntArrayEntity smallArray = new IntArrayEntity(1L, new int[]{1, 2});
        IntArrayEntity bigArray = new IntArrayEntity(2L, new int[]{1, 2, 3, 4});

        SizeComparator comparator = new SizeComparator();

        assertTrue(comparator.compare(smallArray, bigArray) < 0);
    }
}
