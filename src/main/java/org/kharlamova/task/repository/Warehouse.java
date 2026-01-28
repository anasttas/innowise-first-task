package org.kharlamova.task.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kharlamova.task.entity.ArrayStatistic;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.observer.ArrayObserver;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger();

    private static Warehouse instance;

    private final Map<Long, ArrayStatistic> stats = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    @Override
    public void update(IntArrayEntity arrayEntity) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] arr = arrayEntity.getArray();

        for (int v : arr) {
            sum += v;
            if (v < min) min = v;
            if (v > max) max = v;
        }

        double avg = arr.length > 0 ? (double) sum / arr.length : 0;

        stats.put(arrayEntity.getId(), new ArrayStatistic(max, min, sum, avg);
    }
}
