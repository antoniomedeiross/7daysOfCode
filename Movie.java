// DAY 3

// Title
// URL
// Note
// Year

record Movie(String title, String url, String note, String year) {
  public Movie(String title, String url, String note, String year){
    this.title = title;
    this.url = "https://image.tmdb.org/t/p/original/" + url;
    this.note = note.substring(0, 3);
    this.year = "Lançamento " + year.substring(8,10) + "/" + year.substring(5, 7) + "/" + year.substring(0, 4);
  }
} // 0000-00-00


