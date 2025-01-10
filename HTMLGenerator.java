import java.io.IOException;
import java.io.FileWriter;
import java.util.List;

public class HTMLGenerator {  
  List<Movie> listMovies;

  // public static void main(String[] args) {
  // }

  public HTMLGenerator(List<Movie> listMovies){
    this.listMovies = listMovies;
  }

  public void generate(/*List<Movie> listMovie*/) {
    // Gerar o HTML da página aqui
    String head = getHead();
    String body = getBody();
    try {
      FileWriter writer = new FileWriter("movies.html");
      writer.write(head);
      writer.write(body);
      writer.close();
    } catch(IOException e) {
      System.out.println("ErrOr \n" + e);
    } 
  }

  private String getHead() {
    return """
        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
          <title>Lista de filmes</title>
        </head>
        """;
  }

  private String getBody() {
    return """
        <body class="m-0 bg-dark text-white">
          <h1 class="m-3 text-center display-4">Filmes populares para você</h1>
          <div class="container">
            <div class="row justify-content-center">
          """+ 
            getCard(listMovies)
          +"""
              </div>
          </div>
          """ + getFooter() +
          """
        </body>
      """;
  }

  private String getCard(List<Movie> listaMovies) {
    String cards = """
    """;
    for (Movie movie : listaMovies) {
      // fazer a logiica dos cards
      cards += ("""
          <div class="card m-3 bg-secondary text-white" style="width: 18rem;">
            <img class="card-img-top" src=""" + movie.url() + """
            alt="Card image cap">
            <div class="card-body">
              <h5 class="card-title"> """ + movie.title() + """
              </h5>
              <p class="card-text">⭐""" + movie.note() + """
              </p>
              <p class="card-text">""" + movie.year() + """ 
              </p>
            </div>
            
          </div>"""
        );
    }
    return cards;
  }

  private String getFooter(){
    return """
         <footer class="bg-secondary text-center text-white py-3 mt-5">
          <p>Desenvolvido por <strong>Antonio Medeiros</strong></p>
        </footer>
        """;
  }
}

/*
 <p>
    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
      Mais infos
    </button>
  </p>
  <div class="collapse" id="collapseExample">
    <div class="card card-body">
    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
    </div>
  </div>
 */


/*
 * <body class="bg-dark">

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
