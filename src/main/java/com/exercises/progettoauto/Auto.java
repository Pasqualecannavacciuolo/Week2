package com.exercises.progettoauto;

public class Auto {
    private String nome;
    private String nazione;
    private int fatturato;
    private int dipendenti;

    public String getNome() {
        return nome;
    }

    public String getNazione() {
        return nazione;
    }

    public int getFatturato() {
        return fatturato;
    }

    public int getDipendenti() {
        return dipendenti;
    }

    public Auto(){}

    public Auto(String nome, String nazione, int fatturato, int dipendenti) {
        this.nome = nome;
        this.nazione = nazione;
        this.fatturato = fatturato;
        this.dipendenti = dipendenti;
    }
}
