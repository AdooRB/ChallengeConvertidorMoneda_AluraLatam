import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DatosApi {
    private String infoJson;
    private Gson gson = new Gson();
    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;
    private HttpResponse<String> response;
    private DatasApi datas;

    public DatosApi(String desde, String para) throws IOException, InterruptedException {
        Direccion url = new Direccion(desde);
        request =HttpRequest.newBuilder()
                .uri(URI.create(url.getURLnueva()))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        infoJson = response.body();
        //System.out.println(infoJson);

        datas = (gson.fromJson(infoJson, DatasApi.class));
        //System.out.println(datas);
    }

}
