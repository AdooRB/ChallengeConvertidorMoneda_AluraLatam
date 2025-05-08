import java.util.*;

public class Menu {
    private HashMap<String, String> coleccionDivisas = new HashMap<>();
    private HashMap<Integer, String> listaDeOpciones = new HashMap<>();
    private String divisaPrincipal;
    private int opcionesNumero;

    public HashMap<String, String> getColeccionDivisas() {
        return coleccionDivisas;
    }

    public HashMap<Integer, String> getListaDeOpciones() {
        return listaDeOpciones;
    }

    public String getDivisaPrincipal() {
        return divisaPrincipal;
    }

    public void setDivisaPrincipal(String divisaPrincipal) {
        this.divisaPrincipal = divisaPrincipal;
    }

    public int getOpcionesNumero() {
        opcionesNumero = listaDeOpciones.size() + 1;

        if(coleccionDivisas.size() == 0){
            opcionesNumero = 1;
        }
        return opcionesNumero;
    }

    public void agregarDivisa(String divisa, String nombreDivisa){
        coleccionDivisas.put(divisa, nombreDivisa);
    }

    public void quitarDivisa(String divisa){
        coleccionDivisas.remove(divisa);
    }

    public void generarMenu(){
        String menuDivisas = """
                *************************************************
                Sea bienvenido/a al Conversor de Mondedas  =)
                """;
        //List<Object> soloDivisas = Arrays.stream(coleccionDivisas.keySet().toArray()).toList();
        int numeral = 0;

        for (String value : coleccionDivisas.keySet()) {
            if (value != divisaPrincipal){
            numeral ++;
            menuDivisas += "\n  " + numeral + ") " + coleccionDivisas.get(divisaPrincipal) + " =>> " + coleccionDivisas.get(value);
            numeral ++;
            menuDivisas += "\n  " + numeral + ") " + coleccionDivisas.get(value) + " =>> " + coleccionDivisas.get(divisaPrincipal);
            listaDeOpciones.put(numeral - 1, value);
            listaDeOpciones.put(numeral, value);

            }
        }
        numeral++;
        menuDivisas += "\n  " + numeral + ") Salir";
        menuDivisas += "\n\nElija la opción válida:";
        System.out.println(menuDivisas);

    }

}
