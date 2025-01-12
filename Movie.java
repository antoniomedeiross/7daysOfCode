// DAY 3

public class Movie implements Content, Comparable<Content> {
  private String title;
  private String url;
  private String note;
  private String year;
  
  public Movie(String title, String url, String note, String year){
    this.title = title;
    this.url = "https://image.tmdb.org/t/p/original/" + url;
    this.note = note.substring(0, 3);
    this.year = "Lançamento " + year.substring(8,10) + "/" + year.substring(5, 7) + "/" + year.substring(0, 4);
  }

  @Override 
  public String title() {
    return title;
  }
  
  @Override 
  public String url() {
    return url;
  }
  
  @Override 
  public String note() {
    return note;
  }
  
  @Override 
  public String year() {
    return year;
  }
  
  @Override
  public int compareTo(Content outro) {
    return this.note().compareTo(outro.note());
  }
}


