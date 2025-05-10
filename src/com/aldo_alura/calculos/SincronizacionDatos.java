package com.aldo_alura.calculos;

import com.aldo_alura.datos.AlmacenaNota;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SincronizacionDatos {

    public void guardarDatos(AlmacenaNota almacenamiento) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("Notas.json");
        escritura.write(gson.toJson(almacenamiento));
        escritura.close();
        System.out.println("Notas transferidas en json");
    }

}
