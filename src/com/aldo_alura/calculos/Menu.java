package com.aldo_alura.calculos;

import java.util.*;

public class Menu {
    private HashMap<String, String> coleccionDivisas = new HashMap<>();
    private HashMap<Integer, String> listaDeOpciones = new HashMap<>();
    private String divisaPrincipal;
    private int opcionesNumero;

    public HashMap<String, String> getColeccionDivisas() {
        return coleccionDivisas;
    }

    public HashMap<Integer, String> getListaDeOpciones() {
        return listaDeOpciones;
    }

    public String getDivisaPrincipal() {
        return divisaPrincipal;
    }

    public void setDivisaPrincipal(String divisaPrincipal) {
        this.divisaPrincipal = divisaPrincipal;
    }

    public int getOpcionesNumero() {
        opcionesNumero = listaDeOpciones.size() + 2;

        if(coleccionDivisas.size() == 0){
            opcionesNumero = 1;
        }
        return opcionesNumero;
    }

    public void agregarDivisa(String divisa, String nombreDivisa){
        coleccionDivisas.put(divisa, nombreDivisa);
    }

    public void quitarDivisa(String divisa){
        coleccionDivisas.remove(divisa);
    }

    public void generarMenu(){
        String menuDivisas = """
                *************************************************
                Sea bienvenido/a al Conversor de Mondedas  =)
                """;
        //List<Object> soloDivisas = Arrays.stream(coleccionDivisas.keySet().toArray()).toList();
        int numeral = 0;

        for (String value : coleccionDivisas.keySet()) {
            if (value != divisaPrincipal){
            numeral ++;
            menuDivisas += "\n  " + numeral + ") " + coleccionDivisas.get(divisaPrincipal) + " =>> " + coleccionDivisas.get(value);
            numeral ++;
            menuDivisas += "\n  " + numeral + ") " + coleccionDivisas.get(value) + " =>> " + coleccionDivisas.get(divisaPrincipal);
            listaDeOpciones.put(numeral - 1, value);
            listaDeOpciones.put(numeral, value);

            }
        }
        numeral++;
        menuDivisas += "\n  " + numeral + ") Historial";
        numeral++;
        menuDivisas += "\n  " + numeral + ") Salir";
        menuDivisas += "\n\nElija una opción válida:";

        if (divisaPrincipal == null){
            throw new NullPointerException("Error, no hay un parámetro como 'Divisa Principal'");
        } else if (!coleccionDivisas.containsKey(divisaPrincipal)) {
            throw new ArithmeticException("Error, no se encuentra en la 'Divisa Principal' dentro de la Collección de Divisas");
        }
        System.out.println(menuDivisas);

    }

}
