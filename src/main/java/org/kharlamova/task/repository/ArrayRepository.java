package org.kharlamova.task.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kharlamova.task.entity.IntArrayEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepository {
    private static final Logger logger = LogManager.getLogger();

    private List<IntArrayEntity> arrayEntities = new ArrayList<>();

    private static ArrayRepository instance;

    private ArrayRepository() {
    }

    public static ArrayRepository getInstance() {
        if (instance == null) {
            instance = new ArrayRepository();
        }

        return instance;
    }

    public IntArrayEntity getById(Long id) {
        for (IntArrayEntity intArrayEntity : arrayEntities) {
            if (intArrayEntity.getId().equals(id)) {
                logger.info("IntArrayEntity found: {}", intArrayEntity);

                return intArrayEntity;
            }
        }

        logger.info("Element not found with id : {}", id);

        return null;
    }

    public List<IntArrayEntity> getAll() {
        return new ArrayList<IntArrayEntity>(arrayEntities);
    }

    public void add(IntArrayEntity intArrayEntity) {
        arrayEntities.add(intArrayEntity);
    }

    public void remove(IntArrayEntity intArrayEntity) {
        arrayEntities.remove(intArrayEntity);
    }

    public void deleteAll() {
        arrayEntities.clear();
    }

    public void sort(Comparator<IntArrayEntity> comparator) {
        arrayEntities.sort(comparator);
    }
}
