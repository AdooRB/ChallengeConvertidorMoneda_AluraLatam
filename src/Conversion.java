import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.util.HashMap;
import java.util.Scanner;

public class Conversion {
    private ConexionHTTP conexion;
    private HashMap<String,String> divisas;
    private HashMap<Integer,String> opciones;
    private String divisaPrincipal;
    private int opcion;
    private double resouesta;
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
        resouesta = interaccion.nextDouble();
        datoConvertido = resouesta * conexion.getValorFiltrado();
        System.out.println(datoConvertido);
    }

    public void muestraResultado(){
        String mensaje = "\nEl valor de %s corresponde al valor final de =>> %s\n";
        String valorInicial;
        String valorFinal;

        if (opcion % 2 == 1) {
           valorInicial = resouesta + " en " + divisas.get(divisaPrincipal);
           valorFinal = datoConvertido + " en " + divisas.get(opciones.get(opcion));
       } else {
           valorInicial = resouesta + " en " + divisas.get(opciones.get(opcion));
           valorFinal = datoConvertido + " en " + divisas.get(divisaPrincipal);
       }

        System.out.println(String.format(mensaje,valorInicial,valorFinal));
    }

}
