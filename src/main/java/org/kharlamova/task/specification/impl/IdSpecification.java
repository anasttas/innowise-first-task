package org.kharlamova.task.specification.impl;

import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.specification.ArraySpecification;

public class IdSpecification implements ArraySpecification {
    private final Long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean isSatisfiedBy(IntArrayEntity array) {
        return array.getId().equals(id);
    }
}
