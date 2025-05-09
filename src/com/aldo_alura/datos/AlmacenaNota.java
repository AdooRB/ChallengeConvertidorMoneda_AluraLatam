package com.aldo_alura.datos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlmacenaNota {
    private List<NotaData> listaData =new ArrayList<>();
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public List<NotaData> getListaData() {
        return listaData;
    }

    public void  agrega(NotaData notaData){
        NotaData nuevaNota = new NotaData(notaData);
        listaData.add(nuevaNota);
    }

    public void guardaData() throws IOException {
        FileWriter escritura = new FileWriter("Notas.json");
        escritura.write(gson.toJson(listaData));
        escritura.close();
        System.out.println("Notas transferidas en json");

    }

}
