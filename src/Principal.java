import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Menu menu = new Menu();
        Scanner interaccion = new Scanner(System.in);
        Conversion conversionDivisas = new Conversion();
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
            if (respuesta == menu.getOpcionesNumero()){
                break;
            }
            conversionDivisas.inicia(respuesta, menu);
            conversionDivisas.muestraResultado();
        }

    }

}
