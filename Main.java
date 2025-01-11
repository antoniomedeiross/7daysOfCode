import java.util.ArrayList;
import java.util.List;


  public class Main {
    private List<Movie> listMovies; 

    public static void main(String[] args) {
        Main day2 = new Main(); 
        String response = OmdbApiClient.main(args);
  
        day2.initializeListMovies(response);
        List<Movie> movies = day2.getListMovies(); 
        day2.listarList(movies); // testes comentar !!!

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


// HTML 
/*
<body class="bg-dark">

  <div class="container"></div>
    <div class="row justify-content-center">

      <div class="card m-3 bg-secondary text-white" style="width: 18rem;">
        <img class="card-img-top" src="https://br.web.img3.acsta.net/r_1920_1080/img/b1/35/b1351babe7a777b7a97eded3db356990.jpg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Card title</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
      </div>
      <div class="card m-3  bg-secondary text-white" style="width: 18rem;">
        <img class="card-img-top" src="https://br.web.img3.acsta.net/r_1920_1080/img/b1/35/b1351babe7a777b7a97eded3db356990.jpg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Card title</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
      </div>

      
    </div>
  </div>
  
</body>
 */