package Ex2;

import java.util.List;

public class Builder {
    private final String title;
    private final Person director;
    private int year;
    private Person writer;
    private String series;
    private List<Person> cast;
    private List<Place> locations;
    private List<String> languages;
    private List<String> genres;
    private boolean isTelevision;
    private boolean isNetflix;
    private boolean isIndependent;

    public Builder(String title, Person director) {
        this.title = title;
        this.director = director;
    }

    public Builder year(int year) {
        this.year = year;
        return this;
    }

    public Builder writer(Person writer) {
        this.writer = writer;
        return this;
    }

    public Builder series(String series) {
        this.series = series;
        return this;
    }

    public Builder cast(List<Person> cast) {
        this.cast = cast;
        return this;
    }

    public Builder locations(List<Place> locations) {
        this.locations = locations;
        return this;
    }

    public Builder languages(List<String> languages) {
        this.languages = languages;
        return this;
    }

    public Builder genres(List<String> genres) {
        this.genres = genres;
        return this;
    }

    public Builder isTelevision(boolean isTelevision) {
        this.isTelevision = isTelevision;
        return this;
    }

    public Builder isNetflix(boolean isNetflix) {
        this.isNetflix = isNetflix;
        return this;
    }

    public Builder isIndependent(boolean isIndependent) {
        this.isIndependent = isIndependent;
        return this;
    }

    public Movie build() {
        return new Movie(title, year, director, writer, series, cast, locations, languages, genres, isTelevision, isNetflix, isIndependent);
    }
}
