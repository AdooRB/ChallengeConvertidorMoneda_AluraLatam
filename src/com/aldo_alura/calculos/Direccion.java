package com.aldo_alura.calculos;

public class Direccion {
    private String urlOrigin = "https://v6.exchangerate-api.com/v6/35b3ba3cc1f9f011a619d682/latest/";
    private String URLnueva;

    public String getURLnueva() {
        return URLnueva;
    }

    public Direccion(String busqueda){
        URLnueva = urlOrigin + busqueda;
    }

}
