import com.aldo_alura.calculos.*;
import com.aldo_alura.datos.AlmacenaNota;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        try {
            Menu menu = new Menu();
            Scanner interaccion = new Scanner(System.in);
            Conversion conversionDivisas = new Conversion();
            AlmacenaNota  almacenamiento = new AlmacenaNota();
            int respuesta;

            menu.agregarDivisa("USD", "Dólar");
            menu.agregarDivisa("JPY", "Yen Japonés");
            menu.agregarDivisa("COP", "Peso Colombiano");
            menu.agregarDivisa("BRL", "Real Brasileño");
            menu.agregarDivisa("MXN", "Peso Mexicano");
            //menu.agregarDivisa("ARG", "Peso Argentino");

            menu.setDivisaPrincipal("USD");

            while (true) {
                menu.generarMenu();
                respuesta = interaccion.nextInt();

                if (respuesta == menu.getOpcionesNumero()) {
                    System.out.println("Fin del Programa.");
                    break;
                } else if (respuesta > menu.getOpcionesNumero() || respuesta < 1){
                    throw new ArithmeticException("Error, valor introducido fuera de rango");
                }

                conversionDivisas.inicia(respuesta, menu);
                conversionDivisas.muestraResultado();

                almacenamiento.agrega(conversionDivisas.exportaDatos());
                System.out.println(conversionDivisas.exportaDatos().toString());
            }
            almacenamiento.guardaData();
        } catch (NullPointerException |ArithmeticException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (ConnectException e){
            System.out.println("Error de conexión del internet");
        } catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

}
