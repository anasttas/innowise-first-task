package org.kharlamova.task.comparator;

import org.kharlamova.task.entity.IntArrayEntity;

import java.util.Comparator;

public class IdComparator implements Comparator<IntArrayEntity> {
    @Override
    public int compare(IntArrayEntity firstArray, IntArrayEntity secondArray) {
        return Long.compare(firstArray.getId(), secondArray.getId());
    }
}
