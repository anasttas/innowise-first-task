package org.kharlamova.task.observer;

import org.kharlamova.task.entity.IntArrayEntity;

public class ArrayEvent {
    private final IntArrayEntity intArrayEntity;

    public ArrayEvent(IntArrayEntity array){
        this.intArrayEntity = array;
    }

    public IntArrayEntity getArray(){
        return intArrayEntity;
    }
}
