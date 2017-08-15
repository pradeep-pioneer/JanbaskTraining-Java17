package com.janbask.training3;

public class ExplicitSyncedAccess {
    private float value;

    public ExplicitSyncedAccess(){
        value=0f;
    }

    public float getValue(){
        synchronized (this) {
            return value;
        }
    }

    public void addValue(float value){
        //you can even lock any custom object
        synchronized (this){
            this.value+=value;
        }
    }

    public void deductValue(float value){
        synchronized (this) {
            this.value -= value;
        }
    }
}
