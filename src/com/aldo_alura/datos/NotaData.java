package com.aldo_alura.datos;

public class NotaData {
    private String fechaHora;
    private String divisaOriginal;
    private String divisaAConvertir;
    private double cantidadOriginal;
    private double cantidadConvertida;

    public NotaData(){
    }

    public NotaData(NotaData notaData){
        this.fechaHora = notaData.fechaHora;
        this.divisaOriginal = notaData.divisaOriginal;
        this.divisaAConvertir = notaData.divisaAConvertir;
        this.cantidadOriginal = notaData.cantidadOriginal;
        this.cantidadConvertida = notaData.cantidadConvertida;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setDivisaOriginal(String divisaOriginal) {
        this.divisaOriginal = divisaOriginal;
    }

    public void setDivisaAConvertir(String divisaAConvertir) {
        this.divisaAConvertir = divisaAConvertir;
    }

    public void setCantidadOriginal(double cantidadOriginal) {
        this.cantidadOriginal = cantidadOriginal;
    }

    public void setCantidadConvertida(double cantidadConvertida) {
        this.cantidadConvertida = cantidadConvertida;
    }

    @Override
    public String toString() {
        return String.format("  %s  |  %.2f %s  ->>   %.2f %s", fechaHora,cantidadOriginal,divisaOriginal,cantidadConvertida,divisaAConvertir);
    }
}
