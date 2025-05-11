package com.aldo_alura.calculos;

import java.io.File;

public class VerificarJson {

    public boolean existe(){
        File archivoJson = new File("Notas.json");
        boolean existente = false;

        if (archivoJson.exists()){
            existente = true;
        }
        return existente;
    }
}
