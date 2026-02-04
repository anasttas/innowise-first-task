package org.kharlamova.task.observer;

import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.exception.CustomArrayException;

public interface ArrayObserver {
    void update(ArrayEvent event) throws CustomArrayException;
}
