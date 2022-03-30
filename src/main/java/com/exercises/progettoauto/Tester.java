package com.exercises.progettoauto;
/**
 * Scrivere una base di dati AUTO che ha i seguenti campi
 * ID
 * marchio
 * nazione
 * fatturato
 * dipendenti
 *
 * Query da fare:
 * Elencare marchio e fatturato in ordine discendente
 * Elencare numero di marchi per nazione
 * Elencare numero dipendenti per nazione
 * Elencare per ogni marchio il fatturato in ordine decrescente
 * Elencare il fatturato per nazione in ordine decrescente
 * Eliminare un record tramite ID
 *
 * Eseguire un query per ID (trovare un qualcosa tramite l’ID)
 *
 * Mettere in diversi thread le varie operazioni
 */

import java.sql.SQLException;

public class Tester {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Thread thread = new Thread(new CreateTable());
        thread.start();
        thread.setPriority(1);
        thread = new Thread(new Insert());
        thread.start();
        thread.setPriority(2);
    }
}
