package com.theory.multithreading;

import com.utility.LOG;

public class ThreadNumberPrinter extends Thread{
    static LOG L = LOG.getInstance();
    int min, max;

    public ThreadNumberPrinter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void run() {
        for(int i=min; i<=max; i++) {
            L.info(i);
        }
    }

    public static void main(String[] args) {
        ThreadNumberPrinter threadNumberPrinter = new ThreadNumberPrinter(4,6);
        threadNumberPrinter.start();
        L.info("Done!");
    }
}
