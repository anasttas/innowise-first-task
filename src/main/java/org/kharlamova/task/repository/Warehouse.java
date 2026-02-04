package org.kharlamova.task.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kharlamova.task.entity.ArrayStatistic;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
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

    public ArrayStatistic getData(Long id) {
        return statistic.get(id);
    }

    public void putData(Long id, ArrayStatistic data) {
        statistic.put(id, data);
    }
}
