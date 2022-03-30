package com.theory.multithreading;

public class DeterministicMultiThread {
    public static void main(String[] args) throws InterruptedException{
        ThreadNumberPrinter threadNumberPrinter = new ThreadNumberPrinter(4,6);
        threadNumberPrinter.start();
        // Forza l'ordine di esecuzione restituisce il controllo al main solo dopo che il Thread ha terminato l'esecuzione
        threadNumberPrinter.join();
        System.out.println("Done");
    }
}
