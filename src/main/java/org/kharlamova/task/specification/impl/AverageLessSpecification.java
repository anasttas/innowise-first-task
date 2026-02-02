package org.kharlamova.task.specification.impl;

import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.repository.Warehouse;
import org.kharlamova.task.specification.ArraySpecification;

public class AverageLessSpecification implements ArraySpecification {
    private final double value;

    public AverageLessSpecification(double value) {
        this.value = value;
    }

    @Override
    public boolean isSatisfiedBy(IntArrayEntity array) {
        return Warehouse.getInstance()
                .getData(array.getId())
                .getAverage() < value;
    }
}
