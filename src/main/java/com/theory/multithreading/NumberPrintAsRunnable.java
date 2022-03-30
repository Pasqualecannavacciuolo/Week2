package com.theory.multithreading;

import com.utility.LOG;

public class NumberPrintAsRunnable implements Runnable {

    static LOG L = LOG.getInstance();
    int min, max;

    public NumberPrintAsRunnable(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i=min; i<=max; i++) {
            L.info(i);
        }
    }

    public static void main(String[] args) {
        ThreadNumberPrinter threadNumberPrinter = new ThreadNumberPrinter(4,6);
        Thread tp = new Thread(threadNumberPrinter);
        tp.start();
        L.info("Done!");
    }
}
