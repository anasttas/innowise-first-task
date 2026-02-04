package org.kharlamova.task.observer.impl;

import org.kharlamova.task.entity.ArrayStatistic;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.exception.CustomArrayException;
import org.kharlamova.task.observer.ArrayEvent;
import org.kharlamova.task.observer.ArrayObserver;
import org.kharlamova.task.repository.Warehouse;
import org.kharlamova.task.service.ArrayOperations;
import org.kharlamova.task.service.impl.ArrayOperationsImpl;

public class ArrayObserverImpl implements ArrayObserver {
    private final Warehouse warehouse = Warehouse.getInstance();

    private final ArrayOperations service = new ArrayOperationsImpl();

    @Override
    public void update(ArrayEvent event) throws CustomArrayException {
        IntArrayEntity array = event.getArray();

        try {
            ArrayStatistic stats = new ArrayStatistic(
                    service.min(array),
                    service.max(array),
                    service.sumValues(array),
                    service.average(array)
            );

            warehouse.putData(array.getId(), stats);

        } catch (CustomArrayException e) {
            throw new CustomArrayException("Failed to calculate array statistics");
        }
    }
}
