package org.kharlamova.task.specification.impl;

import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.repository.Warehouse;
import org.kharlamova.task.specification.ArraySpecification;

public class MaxEqualsSpecification implements ArraySpecification {
    private final int value;

    public MaxEqualsSpecification(int value) {
        this.value = value;
    }

    @Override
    public boolean isSatisfiedBy(IntArrayEntity array) {
        return Warehouse.getInstance()
                .getData(array.getId())
                .getMax() == value;
    }
}
