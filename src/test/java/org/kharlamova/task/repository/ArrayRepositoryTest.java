package org.kharlamova.task.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kharlamova.task.comparator.FirstElementComparator;
import org.kharlamova.task.comparator.IdComparator;
import org.kharlamova.task.comparator.SizeComparator;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.specification.impl.AverageLessSpecification;
import org.kharlamova.task.specification.impl.MaxEqualsSpecification;
import org.kharlamova.task.specification.impl.SumGreaterSpecification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayRepositoryTest {
    private ArrayRepository repository;
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        repository = ArrayRepository.getInstance();
        warehouse = Warehouse.getInstance();

        repository.query(array -> true).forEach(repository::remove);
    }

    @Test
    void testAddAndRemove() {
        IntArrayEntity array1 = new IntArrayEntity(1L, new int[]{1, 2, 3});
        repository.add(array1);

        List<IntArrayEntity> all = repository.query(array -> true);
        assertEquals(1, all.size());

        repository.remove(array1);
        all = repository.query(array -> true);
        assertEquals(0, all.size());
    }

    @Test
    void testSortById() {
        IntArrayEntity array1 = new IntArrayEntity(2L, new int[]{1});
        IntArrayEntity array2 = new IntArrayEntity(1L, new int[]{2});

        repository.add(array1);
        repository.add(array2);

        repository.sort(new IdComparator());

        List<IntArrayEntity> all = repository.query(array -> true);
        assertEquals(1L, all.get(0).getId());
        assertEquals(2L, all.get(1).getId());
    }

    @Test
    void testSortBySize() {
        IntArrayEntity array1 = new IntArrayEntity(1L, new int[]{1, 2});
        IntArrayEntity array2 = new IntArrayEntity(2L, new int[]{1, 2, 3, 4});

        repository.add(array1);
        repository.add(array2);

        repository.sort(new SizeComparator());

        List<IntArrayEntity> all = repository.query(array -> true);
        assertEquals(1L, all.get(0).getId());
        assertEquals(2L, all.get(1).getId());
    }

    @Test
    void testSortByFirstElement() {
        IntArrayEntity array1 = new IntArrayEntity(1L, new int[]{5, 2});
        IntArrayEntity array2 = new IntArrayEntity(2L, new int[]{3, 4});

        repository.add(array1);
        repository.add(array2);

        repository.sort(new FirstElementComparator());

        List<IntArrayEntity> all = repository.query(array -> true);
        assertEquals(2L, all.get(0).getId());
        assertEquals(1L, all.get(1).getId());
    }

    @Test
    void testSpecificationsWithWarehouse() {
        IntArrayEntity array1 = new IntArrayEntity(1L, new int[]{1, 2, 3}); // sum=6, avg=2, max=3, min=1, size=3
        IntArrayEntity array2 = new IntArrayEntity(2L, new int[]{10, 20});   // sum=30, avg=15, max=20, min=10, size=2

        array1.subscribe(warehouse);
        array2.subscribe(warehouse);

        repository.add(array1);
        repository.add(array2);

        array1.notifyObservers();
        array2.notifyObservers();

        SumGreaterSpecification sumSpec = new SumGreaterSpecification(10);
        List<IntArrayEntity> sumResult = repository.query(sumSpec);
        assertEquals(1, sumResult.size());
        assertEquals(2L, sumResult.get(0).getId());

        AverageLessSpecification avgSpec = new AverageLessSpecification(10);
        List<IntArrayEntity> avgResult = repository.query(avgSpec);
        assertEquals(1, avgResult.size());
        assertEquals(1L, avgResult.get(0).getId());

        MaxEqualsSpecification maxSpec = new MaxEqualsSpecification(20);
        List<IntArrayEntity> maxResult = repository.query(maxSpec);
        assertEquals(1, maxResult.size(), "Exactly one array should be returned");
        assertEquals(2L, maxResult.get(0).getId(), "The ID of the array should be 2");
    }
}
