package org.kharlamova.task.comparator;

import org.junit.jupiter.api.Test;
import org.kharlamova.task.entity.IntArrayEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstElementComparatorTest {

    @Test
    void testCompareByFirstElement() {
        IntArrayEntity a = new IntArrayEntity(1L, new int[]{1, 2});
        IntArrayEntity b = new IntArrayEntity(2L, new int[]{5, 6});

        FirstElementComparator comparator = new FirstElementComparator();

        assertTrue(comparator.compare(a, b) < 0);
    }
}
