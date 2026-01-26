package org.kharlamova.task.factory;

import org.kharlamova.task.entity.IntArrayEntity;

public interface ArrayFactory {
    IntArrayEntity createArray(Long id, int[] array);
}
