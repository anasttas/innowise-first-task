package org.kharlamova.task.factory.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.factory.ArrayFactory;

public class ArrayFactoryImpl implements ArrayFactory {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public IntArrayEntity createArray(Long id, int[] array) {
        logger.debug("ArrayFactory created IntArrayEntity with id={}", id);

        return new IntArrayEntity(id, array);
    }
}
