package org.kharlamova.task.comparator;

import org.junit.jupiter.api.Test;
import org.kharlamova.task.entity.IntArrayEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IdComparatorTest {
    @Test
    void testCompareById() {
        IntArrayEntity a = new IntArrayEntity(1L, new int[]{});
        IntArrayEntity b = new IntArrayEntity(2L, new int[]{});

        IdComparator comparator = new IdComparator();

        assertTrue(comparator.compare(a, b) < 0);
    }
}
