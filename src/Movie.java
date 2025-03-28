import java.util.Objects;

public class Movie {

    private String name;
    private double rating;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            System.out.println("Please enter rating between 0 and 10.");
            return;
        }

        this.rating = rating;
    }

    public Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(rating, movie.rating) == 0 && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating);
    }

    public Movie() {
    }

}