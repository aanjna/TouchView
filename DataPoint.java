package com.example.mahe.touch;

/**
 * Created by Choudhary on 10/07/2016.
 */
public class DataPoint {
    public float x;
    public float y;
    int id;

    public DataPoint() {}

    public DataPoint(int id, float x, float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    public DataPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id= id;
    }
    public float getX(){
        return this.x;
    }
    public void setX(float x){
        this.x=x;
    }
    public float getY(){
        return this.y;
    }
    public void setY(float y){
        this.y=y;
    }
}

