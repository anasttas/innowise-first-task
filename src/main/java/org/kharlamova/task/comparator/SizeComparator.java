package org.kharlamova.task.comparator;

import org.kharlamova.task.entity.IntArrayEntity;

import java.util.Comparator;

public class SizeComparator implements Comparator<IntArrayEntity> {
    @Override
    public int compare(IntArrayEntity firstArray, IntArrayEntity secondArray) {
        return Integer.compare(firstArray.getSize(), secondArray.getSize());
    }
}
