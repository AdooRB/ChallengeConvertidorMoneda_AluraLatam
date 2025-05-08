import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DatosApi {
    private String infoJson;
    private Gson gson;
    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;
    private HttpResponse<String> response;

    public DatosApi(String desde, String para) throws IOException, InterruptedException {
        Direccion url = new Direccion(desde);
        request =HttpRequest.newBuilder()
                .uri(URI.create(url.getURLnueva()))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        infoJson = response.body();
        System.out.println(infoJson);
    }

}
