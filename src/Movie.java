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


    public Movie() {
    }

}