import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Movie[] movies = new Movie[0];

    public static void main(String[] args) {

        System.out.println();
        System.out.println("*********************** Welcome to the Movie App! ***********************");
        createMenu();
    }

    private static void createMenu() {

        while (true) {
            displayChoices();
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                addMovie();
            } else if (choice.equals("2")) {
                displayMovies();
            } else if (choice.equals("3")) {
                displayStatistics();
            } else if (choice.equals("4")) {
                searchMovie();
            } else if (choice.equals("5")) {
                changeRatingOfMovie();
            } else if (choice.equals("6")) {
                deleteMovie();
            } else if (choice.equals("7")) {
                sortMovies();
            } else if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    private static void sortMovies() {

        double[] arr = new double[movies.length];
        for (int i = 0; i < movies.length; i++) {
            arr[i] = movies[i].getRating();
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            double temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }

        for (double v : arr) {
            for (Movie movie : movies) {
                if (v == movie.getRating()) {
                    System.out.println(movie.getName() + " " + movie.getRating());
                }
            }
        }

    }


    private static void changeRatingOfMovie() {
        displayMovies();

        System.out.println("Enter the movie name you want to update its rating");
        String name = scanner.nextLine();

        System.out.println("Enter new rating");
        double newRating = scanner.nextDouble();
        scanner.nextLine();

        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                movie.setRating(newRating);
                return;
            }
        }

        System.out.println("Movie not found!");
    }

    private static void deleteMovie() {
        System.out.println("Enter the movie name you want to delete");
        String name = scanner.nextLine();

        Movie[] newMovies = new Movie[movies.length - 1];

        int i = 0;
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                continue;
            } else {
                newMovies[i] = movie;
                i++;
            }
        }
        movies = newMovies;
    }

    private static void searchMovie() {
        System.out.println("Enter the name of the movie you want to search for:");
        String name = scanner.nextLine();

        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                System.out.println();
                System.out.println(movie.getName() + ":  " + movie.getRating());
                return;
            }
        }

        System.out.println("Movie not found");
    }

    private static void displayStatistics() {

        double sum = 0;
        double max = 0;
        double min = 10;

        for (Movie movie : movies) {
            sum += movie.getRating();
            min = Math.min(min, movie.getRating());
            max = Math.max(max, movie.getRating());

        }

        for (Movie movie : movies) {
            if (movie.getRating() == max) {
                System.out.println("The highest rated movie is: " + movie.getName());
            }

            if (movie.getRating() == min) {
                System.out.println("The lowest rated movie is: " + movie.getName());
            }
        }

        System.out.println("The average rating of all movies is: " + sum / movies.length);

    }

    private static void displayChoices() {
        System.out.println();
        System.out.println("1. Add movies");
        System.out.println("2. Display movies");
        System.out.println("3. Show the statistics");
        System.out.println("4. Search for a movie");
        System.out.println("5. Change the rating of a movie");
        System.out.println("6. Delete the movie");
        System.out.println("7. Sort the movies");
        System.out.println("0. Exit");
        System.out.println();
    }

    private static void displayMovies() {
        System.out.println("****************************************");

        for (Movie movie : movies) {
            if (movie != null) {
                System.out.println("Movie name: " + movie.getName());
                System.out.println("Movie rating: " + movie.getRating());
                System.out.println();
            }
        }

        if (movies.length == 0) {
            System.out.println();
            System.out.println("No movies found in the app");
            System.out.println();
        }

        System.out.println("****************************************");
    }

    private static void addMovie() {

        System.out.println("Enter a number of movies you want to add");
        int numberOfMovies = scanner.nextInt();
        scanner.nextLine();

        Movie[] newMovies = new Movie[movies.length + numberOfMovies];

        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i];
        }

        movies = newMovies;

        for (int i = 0; i < numberOfMovies; i++) {
            System.out.println("Enter a movie name");
            String name = scanner.nextLine();

            System.out.println("Enter a movie rating");
            double rating = scanner.nextDouble();
            scanner.nextLine();

            Movie movie = new Movie(name, rating);

            for (int j = 0; j < movies.length; j++) {
                if (movies[j] == null) {
                    movies[j] = movie;
                    break;
                }
            }
        }
    }
}