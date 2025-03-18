package Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando instâncias de Person
        Person director = new Person("John Doe", 40);
        Person writer = new Person("Jane Smith", 35);
        Person actor1 = new Person("Actor 1", 25);
        Person actor2 = new Person("Actor 2", 30);

        // Criando instâncias de Place
        Place location1 = new Place("Location 1", "Address 1");
        Place location2 = new Place("Location 2", "Address 2");

        // Criando listas de elenco, locais, idiomas e gêneros
        List<Person> castList = new ArrayList<>();
        castList.add(actor1);
        castList.add(actor2);

        List<Place> locationsList = new ArrayList<>();
        locationsList.add(location1);
        locationsList.add(location2);

        List<String> languagesList = Arrays.asList("English", "French", "Spanish");

        List<String> genresList = Arrays.asList("Action", "Drama", "Comedy");

        // Criando uma instância de Movie usando o Builder
        Movie movie = new Builder("Barbie", director)
                .year(2023)
                .writer(writer)
                .series("Friends")
                .cast(castList)
                .locations(locationsList)
                .languages(languagesList)
                .genres(genresList)
                .isTelevision(true)
                .isNetflix(true)
                .isIndependent(false)
                .build();

        // Imprimindo detalhes do filme
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Year: " + movie.getYear());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Writer: " + movie.getWriter());
        System.out.println("Series: " + movie.getSeries());
        System.out.println("Cast: " + movie.getCast());
        System.out.println("Locations: " + movie.getLocations());
        System.out.println("Languages: " + movie.getLanguages());
        System.out.println("Genres: " + movie.getGenres());
        System.out.println("Is Television: " + movie.isTelevision());
        System.out.println("Is Netflix: " + movie.isNetflix());
        System.out.println("Is Independent: " + movie.isIndependent());
    }
}
