package com.thomas.streamintjenestekopi;

import java.util.ArrayList;
import java.util.List;

public class UseCase {
    DatabaseHandler databaseHandler = new DatabaseHandler();
    private List<User> users = new ArrayList<>();

    public List<Movie> getFavoritesByEmail (String email) {
        List<Movie> favorites = databaseHandler.getFavoriteMovies(email);
        return favorites;
    }
    public List<Movie> getMoviesSortedByRating() {
        List<Movie> movies = databaseHandler.showMoviesByRating();
        return movies;
    }
    public String addUser(int userId, String firstName, String lastName, String email, String subscriptionType) {
        User user = new User(userId, firstName, lastName, email, subscriptionType);
        String added = databaseHandler.createUserObject(user);
        return added;
    }
    public String addFavoriteMovie(int userId, int movieId) {
        String added = databaseHandler.addFavoriteMovie(userId, movieId);
        return added;
    }
    public List<User> getAllUsers() {
        users = databaseHandler.getAllUsers();
        return users;
    }
}
