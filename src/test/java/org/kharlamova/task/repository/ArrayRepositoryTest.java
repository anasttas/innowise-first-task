package org.kharlamova.task.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kharlamova.task.comparator.FirstElementComparator;
import org.kharlamova.task.comparator.IdComparator;
import org.kharlamova.task.comparator.SizeComparator;
import org.kharlamova.task.entity.IntArrayEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayRepositoryTest {
    private ArrayRepository repository;

    @BeforeEach
    void setUp() {
        repository = ArrayRepository.getInstance();

        repository.streamQuery(array -> true).forEach(repository::remove);
    }

    @Test
    void testAddAndRemove() {
        IntArrayEntity array1 = new IntArrayEntity(1L, new int[]{1, 2, 3});
        repository.add(array1);

        List<IntArrayEntity> all = repository.streamQuery(array -> true);
        assertEquals(1, all.size());

        repository.remove(array1);
        all = repository.streamQuery(array -> true);
        assertEquals(0, all.size());
    }

    @Test
    void testSortById() {
        IntArrayEntity array1 = new IntArrayEntity(2L, new int[]{1});
        IntArrayEntity array2 = new IntArrayEntity(1L, new int[]{2});

        repository.add(array1);
        repository.add(array2);

        repository.sort(new IdComparator());

        List<IntArrayEntity> all = repository.streamQuery(array -> true);
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

        List<IntArrayEntity> all = repository.streamQuery(array -> true);
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

        List<IntArrayEntity> all = repository.streamQuery(array -> true);
        assertEquals(2L, all.get(0).getId());
        assertEquals(1L, all.get(1).getId());
    }
}
