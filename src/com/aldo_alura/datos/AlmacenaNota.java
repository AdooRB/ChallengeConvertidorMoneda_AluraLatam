package com.aldo_alura.datos;

import java.util.ArrayList;
import java.util.List;

public class AlmacenaNota {
    private List<NotaData> listaData =new ArrayList<>();

    public void  agrega(NotaData notaData){
        NotaData nuevaNota = new NotaData(notaData);
        listaData.add(nuevaNota);
    }

}
