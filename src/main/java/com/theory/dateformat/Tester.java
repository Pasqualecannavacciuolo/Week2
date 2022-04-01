package com.theory.dateformat;


import java.text.DateFormat;
import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        Date data = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(dateFormat.format(data));
    }
}
