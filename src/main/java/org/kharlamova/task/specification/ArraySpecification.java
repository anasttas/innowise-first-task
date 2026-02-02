package org.kharlamova.task.specification;

import org.kharlamova.task.entity.IntArrayEntity;

public interface ArraySpecification {
    boolean isSatisfiedBy(IntArrayEntity array);
}
