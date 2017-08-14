package com.janbask.training3;

public class SyncedDataAccess{
    public SyncedDataAccess(){
        value=0f;
    }
    private float value;
    public synchronized float getValue(){
        return value;
    }

    public synchronized void addValue(float value){
        this.value+=value;
    }

    public synchronized void deductValue(float value){
        this.value-=value;
    }
}
