package com.example.kucharska;

public class Przepis {
    private String nazwa;
    private int kategoria;
    private String listaSkladnikow;
    private int idObrazka;

    public Przepis(String nazwa, int kategoria, String listaSkladnikow, int idObrazka) {
        this.nazwa = nazwa;
        this.kategoria = kategoria;
        this.listaSkladnikow = listaSkladnikow;
        this.idObrazka = idObrazka;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getKategoria() {
        return kategoria;
    }

    public void setKategoria(int kategoria) {
        this.kategoria = kategoria;
    }

    public String getListaSkladnikow() {
        return listaSkladnikow;
    }

    public void setListaSkladnikow(String listaSkladnikow) {
        this.listaSkladnikow = listaSkladnikow;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }
}
