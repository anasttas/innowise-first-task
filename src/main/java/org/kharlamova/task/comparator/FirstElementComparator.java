package org.kharlamova.task.comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.exception.CustomArrayException;

import java.util.Comparator;

public class FirstElementComparator implements Comparator<IntArrayEntity> {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int compare(IntArrayEntity firstArray, IntArrayEntity secondArray) {
        try {
            int elementOfFirstArray = firstArray.getElementByIndex(0);

            int elementOfSecondArray = secondArray.getElementByIndex(0);

            return Integer.compare(elementOfFirstArray, elementOfSecondArray);
        } catch (CustomArrayException e) {
            logger.error("Error encountered inside of comparator: {}", e.getMessage());
            return 0;
        }
    }
}
