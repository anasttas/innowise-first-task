package org.kharlamova.task.service.impl;

import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.exception.CustomArrayException;

public interface ArrayOperations {
    int max(IntArrayEntity array) throws CustomArrayException;

    int min(IntArrayEntity array) throws CustomArrayException;

    double sumValues(IntArrayEntity array) throws CustomArrayException;
}
