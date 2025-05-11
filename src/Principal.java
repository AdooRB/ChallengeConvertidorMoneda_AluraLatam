import com.aldo_alura.calculos.*;
import com.aldo_alura.datos.AlmacenaNota;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)  {

        try {
            Menu menu = new Menu();
            Scanner interaccion = new Scanner(System.in);
            Conversion conversionDivisas = new Conversion();
            AlmacenaNota  almacenamiento = new AlmacenaNota();
            SincronizacionDatos sincronizacionDatos = new SincronizacionDatos();
            VerificarJson verificarJson = new VerificarJson();
            int respuesta;

            if (verificarJson.existe()) {
                almacenamiento.actualizaLista(sincronizacionDatos.extraeLista());
            }

            //Agregar divisas y sus nombres a utilizar
            menu.agregarDivisa("USD", "Dólar");
            menu.agregarDivisa("JPY", "Yen Japonés");
            menu.agregarDivisa("COP", "Peso Colombiano");
            menu.agregarDivisa("BRL", "Real Brasileño");
            menu.agregarDivisa("MXN", "Peso Mexicano");
            //menu.agregarDivisa("ARS", "Peso Argentino");

            //agrega la divisa principal
            menu.setDivisaPrincipal("USD");

            while (true) {
                menu.generarMenu();
                respuesta = interaccion.nextInt();

                //Finalizar programa  ||  Respuesta no está en rango de opciones
                if (respuesta == menu.getOpcionesNumero()) {
                    System.out.println("Fin del Programa.");
                    break;

                } else if (respuesta > menu.getOpcionesNumero() || respuesta < 1){
                    throw new ArithmeticException("Error, valor introducido fuera de rango");

                }

                //Iniciar conversión  ||  Opción Historial
                if (respuesta != menu.getOpcionesNumero() - 1) {

                    conversionDivisas.inicia(respuesta, menu);
                    conversionDivisas.muestraResultado();

                    almacenamiento.agrega(conversionDivisas.exportaDatos());
                }else {
                    almacenamiento.muestraHistorial();
                }
            }
            sincronizacionDatos.guardarDatos(almacenamiento);

        } catch (NullPointerException |ArithmeticException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (ConnectException e){
            System.out.println("Error de conexión del internet");
        } catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

}
