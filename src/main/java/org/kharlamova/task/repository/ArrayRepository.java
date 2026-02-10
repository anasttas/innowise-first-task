package org.kharlamova.task.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.specification.ArraySpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public void add(IntArrayEntity intArrayEntity) {
        arrayEntities.add(intArrayEntity);

        logger.info("Array added to repository, id={}", intArrayEntity.getId());
    }

    public void remove(IntArrayEntity intArrayEntity) {
        arrayEntities.remove(intArrayEntity);

        logger.info("Array removed from repository, id={}", intArrayEntity.getId());
    }

    public List<IntArrayEntity> streamQuery(ArraySpecification specification) {
        List<IntArrayEntity> result = arrayEntities.stream()
                .filter(arrayItem -> specification.isSatisfiedBy(arrayItem))
                .collect(Collectors.toList());

        logger.info(
                "Query result size={} for {}",
                result.size(),
                specification.getClass().getSimpleName()
        );

        return result;
    }

    public void sort(Comparator<IntArrayEntity> comparator) {
        logger.info("Sorting arrays using comparator {}",
                comparator.getClass().getSimpleName());

        arrayEntities.sort(comparator);
    }
}
