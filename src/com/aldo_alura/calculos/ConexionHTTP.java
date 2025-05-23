package com.aldo_alura.calculos;

import com.aldo_alura.datos.DatasApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionHTTP {
    private String infoJson;
    private Gson gson = new Gson();
    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;
    private HttpResponse<String> response;
    private DatasApi datas;
    private String divisaObtener;
    private double valorFiltrado;

    public double getValorFiltrado() {
        valorFiltrado = datas.conversion_rates().get(divisaObtener);
        return valorFiltrado;
    }

    public ConexionHTTP(String desde, String para) throws IOException, InterruptedException {
        this.divisaObtener = para;
        Direccion url = new Direccion(desde);
        request =HttpRequest.newBuilder()
                .uri(URI.create(url.getURLnueva()))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        infoJson = response.body();

        datas = (gson.fromJson(infoJson, DatasApi.class));
    }

}
