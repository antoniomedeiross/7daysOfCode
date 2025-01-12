// DAY 1

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class OmdbApiClient {

  public static String main(String[] args) {

    String url = "https://api.themoviedb.org/3/movie/popular";
    String bearToken = "SEU TOKEN";

    return consome(url, bearToken);
  }

  public static String consome(String url, String bearerToken) {
    try {
      HttpClient httpCliente = HttpClient.newHttpClient();

      HttpRequest httpRequest = HttpRequest 
        .newBuilder()
        .uri(new URI(url))
        .GET()
        .header("accept", "application/json")
        .header("Authorization", bearerToken)
        .build();
        

      HttpResponse<String> response = httpCliente.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      System.out.println(response.body());

      return response.body();
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
      return "ERRO NA BUSCA!";
    }
  }
}
