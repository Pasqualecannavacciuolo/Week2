package com.theory.multithreading;

public class Increment implements Runnable{
    private final int[] data;

    public Increment(int[] data) {
        this.data = data;
    }

    @Override
    public void run() {
        for(int i=0; i<data.length; i++) {
            data[i] = data[i]+1;
        }
    }
}
