package org.kharlamova.task.observer.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kharlamova.task.entity.ArrayStatistic;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.exception.CustomArrayException;
import org.kharlamova.task.observer.ArrayEvent;
import org.kharlamova.task.repository.Warehouse;

import static org.junit.jupiter.api.Assertions.*;

class ArrayObserverImplTest {

    private Warehouse warehouse;
    private ArrayObserverImpl observer;

    @BeforeEach
    void setUp() {
        warehouse = Warehouse.getInstance();
        observer = new ArrayObserverImpl();
    }

    @Test
    void testUpdateStoresCorrectStatisticsInWarehouse() throws CustomArrayException {
        IntArrayEntity array = new IntArrayEntity(1L, new int[]{1, 2, 3, 4});
        ArrayEvent event = new ArrayEvent(array);

        observer.update(event);

        ArrayStatistic stats = warehouse.getData(1L);

        assertNotNull(stats, "Statistics should be stored in Warehouse");

        assertEquals(1, stats.getMin());
        assertEquals(4, stats.getMax());
        assertEquals(10.0, stats.getSum());
        assertEquals(2.5, stats.getAverage());
    }
}
