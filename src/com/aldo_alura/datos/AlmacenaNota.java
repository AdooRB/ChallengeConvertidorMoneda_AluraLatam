package com.aldo_alura.datos;

import java.util.ArrayList;
import java.util.List;

public class AlmacenaNota {
    private List<NotaData> listaData = new ArrayList<>();

    public void actualizaLista(List<NotaData> listaData) {
        this.listaData = listaData;
    }

    public void  agrega(NotaData notaData){
        NotaData nuevaNota = new NotaData(notaData);
        listaData.add(nuevaNota);
    }

    public void muestraHistorial(){
        System.out.println("***************************************************");
        System.out.println("                --HISTORIAL--");

        for (int i = 0; i < listaData.size(); i++ ){
            NotaData notaData = new NotaData(listaData.get(i));
            System.out.println("    " + (i + 1) + ")     " + notaData);
        }
        System.out.println("\n***************************************************");

    }

}
