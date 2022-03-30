package com.theory.multithreading;

public class IncrementImplementation {
    public static void main(String[] args) throws InterruptedException{
        int data[] = new int[10000];
        Thread thread = new Thread(new Increment(data));
        thread.start();
        thread.join();
        for(int i=0; i<data.length; i++) {
            int j=data[i];
            if(j!=1) {
                System.out.println("["+i+"] = " + j);
            }
        }
    }
}
