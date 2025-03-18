package Ex2;

import java.util.List;

public class Movie {
   private final String title;
   private final int year;
   private final Person director;
   private final Person writer;
   private final String series;
   private final List<Person> cast;
   private final List<Place> locations;
   private final List<String> languages;
   private final List<String> genres;
   private final boolean isTelevision;
   private final boolean isNetflix;
   private final boolean isIndependent;

   public Movie(String title, int year, Person director, Person writer,
                String series, List<Person> cast, List<Place> locations,
                List<String> languages, List<String> genres,
                boolean isTelevision, boolean isNetflix, boolean isIndependent) {
      this.title = title;
      this.year = year;
      this.director = director;
      this.writer = writer;
      this.series = series;
      this.cast = cast;
      this.locations = locations;
      this.languages = languages;
      this.genres = genres;
      this.isTelevision = isTelevision;
      this.isNetflix = isNetflix;
      this.isIndependent = isIndependent;
   }

   public String getTitle() {
      return title;
   }

   public int getYear() {
      return year;
   }

   public Person getDirector() {
      return director;
   }

   public Person getWriter() {
      return writer;
   }

   public String getSeries() {
      return series;
   }

   public List<Person> getCast() {
      return cast;
   }

   public List<Place> getLocations() {
      return locations;
   }

   public List<String> getLanguages() {
      return languages;
   }

   public List<String> getGenres() {
      return genres;
   }

   public boolean isTelevision() {
      return isTelevision;
   }

   public boolean isNetflix() {
      return isNetflix;
   }

   public boolean isIndependent() {
      return isIndependent;
   }
}
