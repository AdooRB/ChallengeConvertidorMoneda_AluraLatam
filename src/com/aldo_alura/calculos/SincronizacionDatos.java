package com.aldo_alura.calculos;

import com.aldo_alura.datos.AlmacenaNota;
import com.aldo_alura.datos.DatasApp;
import com.aldo_alura.datos.NotaData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SincronizacionDatos {

    public void guardarDatos(AlmacenaNota almacenamiento) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("Notas.json");
        escritura.write(gson.toJson(almacenamiento));
        escritura.close();
        System.out.println("Notas transferidas en json");
    }

    public List<NotaData> extraeLista() throws FileNotFoundException {
        Gson gson = new Gson();
        DatasApp datasApp;
        datasApp = gson.fromJson(lecturaJson(),DatasApp.class);
        return datasApp.listaData();
    }
    private String lecturaJson() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Notas.json"));
        String jsonSTR = "";
        while (scanner.hasNextLine()) {
            jsonSTR = jsonSTR + "\n" + scanner.nextLine();
        }
        System.out.println(jsonSTR);
        scanner.close();
        return jsonSTR;
    }
}
