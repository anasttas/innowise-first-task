package org.kharlamova.task.entity;

public class ArrayStatistic {
    private int max;

    private int min;

    private double sum;

    private double average;

    public ArrayStatistic(int max, int min, double sum, double average) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.average = average;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }
}
