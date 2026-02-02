package org.kharlamova.task.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kharlamova.task.entity.ArrayStatistic;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.exception.CustomArrayException;
import org.kharlamova.task.observer.ArrayEvent;
import org.kharlamova.task.observer.ArrayObserver;
import org.kharlamova.task.service.ArrayOperations;
import org.kharlamova.task.service.impl.ArrayOperationsImpl;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger();

    private static Warehouse instance;

    private final Map<Long, ArrayStatistic> statistic = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
            logger.info("Warehouse instance created");
        }
        return instance;
    }

    public ArrayStatistic getData(long id) {
        return statistic.get(id);
    }

    @Override
    public void update(ArrayEvent event) {
        IntArrayEntity array = event.getArray();
        Long id = array.getId();

        try {
            ArrayOperations service = new ArrayOperationsImpl();
            double sum = service.sumValues(array);
            double avg = service.average(array);
            int max = service.max(array);
            int min = service.min(array);

            ArrayStatistic stats = new ArrayStatistic(min, max, sum, avg);
            statistic.put(id, stats);
        } catch (CustomArrayException e) {
            logger.error("Failed to update warehouse for array " + id, e);
        }
    }
}
