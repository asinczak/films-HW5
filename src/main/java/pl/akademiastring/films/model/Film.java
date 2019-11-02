package pl.akademiastring.films.model;

public class Film {

    private String title;
    private String year;
    private String producer;

    public Film(String title, String year, String producer) {
        this.title = title;
        this.year = year;
        this.producer = producer;
    }

    public Film() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
