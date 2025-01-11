// DAY 1

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class OmdbApiClient {

  public static String main(String[] args) {
    //String url = "http://www.omdbapi.com/?i=tt3896198&apikey=8a7f14be";

    String url = "https://api.themoviedb.org/3/movie/popular";
    String bearToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MGRhZWNmMTc4MmNiOTAwOTRhZjU2YmNiNjNhYjJmZiIsIm5iZiI6MTczNjE4NDAxMS4yNTEwMDAyLCJzdWIiOiI2NzdjMTBjYjhmZDZmNTEwOWQ3MmUzOWIiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.kOldn8DQCqyDYpLYebfsr10k4DjZwPVHsqJvJY47R4Q";

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