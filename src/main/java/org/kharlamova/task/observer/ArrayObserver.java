package org.kharlamova.task.observer;

import org.kharlamova.task.entity.IntArrayEntity;

public interface ArrayObserver {
    void update(ArrayEvent event);
}
