import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


  public class Main {
    private List<Movie> listMovies; 

    public static void main(String[] args) {
        Main day2 = new Main(); 
        String response = OmdbApiClient.main(args);
  
        day2.initializeListMovies(response);
        List<Movie> movies = day2.getListMovies(); 
        day2.listarList(movies); // testes comentar !!!

        Collections.sort(day2.getListMovies());
        Collections.sort(movies, Comparator.reverseOrder());

        HTMLGenerator geradorHtml = new HTMLGenerator(movies); 
        geradorHtml.generate(); 
    }


  public void initializeListMovies(String response) {
    this.listMovies = new ArrayList<>();
    response = response.substring(response.indexOf("results\":[{") + 10, response.indexOf("],\"total_pages"));
    String[] films = response.split("},\\s*\\{");

    for (int i = 0; i < films.length; i++) {
      String title = films[i].substring(films[i].indexOf("\"title\":") + 9, films[i].indexOf("\",\"video"));
      String url = films[i].substring(films[i].indexOf("poster_path\":") + 15, films[i].indexOf("\",\"release_date"));
      String nota = films[i].substring(films[i].indexOf("vote_average\":") + 14, films[i].indexOf(",\"vote_count"));
      String year = films[i].substring(films[i].indexOf("release_date\":") + 15, films[i].indexOf("\",\"title"));

      //listMovies[i] = new Movie(title, url, nota, year); 
      listMovies.add(new Movie(title, url, nota, year));
    }
  }

  public List<Movie> getListMovies() {
    return listMovies;
  }


  // testes
  public void listarList(List<Movie> lista) {
    for (Movie movie : lista) {
      System.out.println("Title: " + movie.title());
      System.out.println("URL: " + movie.url());
      System.out.println("Nota: " + movie.note());
      System.out.println("Year: " + movie.year());
      System.out.println();
    }
  }
}
