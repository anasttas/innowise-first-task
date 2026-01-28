package org.kharlamova.task.service;

import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.exception.CustomArrayException;

public interface ArraySort {
    void bubbleSort(IntArrayEntity array) throws CustomArrayException;
}
