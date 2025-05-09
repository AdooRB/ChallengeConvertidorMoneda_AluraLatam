package com.aldo_alura.calculos;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Conversion {
    private ConexionHTTP conexion;
    private HashMap<String,String> divisas;
    private HashMap<Integer,String> opciones;
    private String divisaPrincipal;
    private int opcion;
    private double respuesta;
    private double datoConvertido;

    public void inicia(int opcion, Menu menu) throws IOException, InterruptedException {
        this.divisas = menu.getColeccionDivisas();
        this.opciones = menu.getListaDeOpciones();
        this.divisaPrincipal = menu.getDivisaPrincipal();
        this.opcion = opcion;
        Scanner interaccion = new Scanner(System.in);

        if(opcion%2 == 1){
            conexion = new ConexionHTTP(divisaPrincipal, opciones.get(opcion));
        }else {
            conexion = new ConexionHTTP(opciones.get(opcion), divisaPrincipal);
        }
        System.out.println("Ingresa el valor que deseas convertir");
        respuesta = interaccion.nextDouble();
        datoConvertido = respuesta * conexion.getValorFiltrado();
    }

    public void muestraResultado(){
        String mensaje = "\nEl valor de %s corresponde al valor final de =>> %s\n";
        String valorInicial;
        String valorFinal;

        if (opcion % 2 == 1) {
            valorInicial = String.format("%.2f en %s",respuesta, divisas.get(divisaPrincipal));
            valorFinal = String.format("%.2f en %s",datoConvertido, divisas.get(opciones.get(opcion)));
       } else {
            valorInicial = String.format("%.2f en %s",respuesta, divisas.get(opciones.get(opcion)));
            valorFinal = String.format("%.2f en %s",datoConvertido, divisas.get(divisaPrincipal));
       }

        System.out.println(String.format(mensaje,valorInicial,valorFinal));
    }

}
