package com.janbask.training3;

public class SimpleDataAccess {
    public SimpleDataAccess(){
        value=0f;
    }
    private float value;
    public float getValue(){
        return value;
    }

    public void addValue(float value){
        this.value+=value;
    }

    public void deductValue(float value){
        this.value-=value;
    }
}
