package org.kharlamova.task.comparator;

import org.kharlamova.task.entity.IntArrayEntity;
import org.kharlamova.task.exception.CustomArrayException;

import java.util.Comparator;

public class FirstElementComparator implements Comparator<IntArrayEntity> {
    @Override
    public int compare(IntArrayEntity firstArray, IntArrayEntity secondArray) {
        try {
            int elementOfFirstArray = firstArray.getElementByIndex(0);

            int elementOfSecondArray = secondArray.getElementByIndex(0);

            return Integer.compare(elementOfFirstArray, elementOfSecondArray);
        } catch (CustomArrayException e) {
            throw new RuntimeException("Unexpected error while comparing arrays", e);
        }
    }
}
