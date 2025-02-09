package com.thomas.streamintjenestekopi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private Stage stage;
    private Scene scene;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public void goToUserMenu(ActionEvent actionEvent) {
        stage.setScene(scene);
        stage.show();
    }

    UseCase useCase = new UseCase();
    private List<Movie> movies = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Movie> favorites = new ArrayList<>();

    ObservableList<Movie> moviesObservable = FXCollections.observableList(movies);
    ObservableList<User> usersObservable = FXCollections.observableList(users);
    ObservableList<Movie> favoritesObservable = FXCollections.observableList(favorites);

    @FXML
    ListView<Movie> movieListView = new ListView<>();
    @FXML
    ListView<User> userListView = new ListView<>();
    @FXML
    ListView<Movie> favoriteListView = new ListView<>();

    @FXML
    Label label = new Label();

    public void onShowAllMoviesClicked(ActionEvent actionEvent) {
        showMovieList();
        movies = useCase.getMoviesSortedByRating();
        moviesObservable.setAll(movies);
        movieListView.setItems(moviesObservable);
    }
    public void onShowAllUsersClicked(ActionEvent actionEvent) {
        showUserList();
        users = useCase.getAllUsers();
        usersObservable.setAll(users);
        userListView.setItems(usersObservable);
    }
    public void showFavoritesClicked(ActionEvent actionEvent) {
        showFavoriteList();
        if (userListView.getSelectionModel().getSelectedItem() != null) {
            String email = userListView.getSelectionModel().getSelectedItem().getEmail();
            favorites = useCase.getFavoritesByEmail(email);
            favoritesObservable.setAll(favorites);
            favoriteListView.setItems(favoritesObservable);
        }
    }
    public void addAsFavorite(ActionEvent actionEvent) {
        if ((userListView.getSelectionModel().getSelectedItem() != null) && (movieListView.getSelectionModel().getSelectedItem() != null)) {
            int userId = userListView.getSelectionModel().getSelectedItem().getUserId();
            int movieId = movieListView.getSelectionModel().getSelectedItem().getMovieId();
            String added = useCase.addFavoriteMovie(userId, movieId);
            label.setText(added);
        }
    }

    @FXML
    public void showMovieList(){
        userListView.setVisible(true);
        favoriteListView.setVisible(false);
        movieListView.setVisible(true);
    }
    @FXML
    public void showUserList(){
        favoriteListView.setVisible(false);
        movieListView.setVisible(true);
        userListView.setVisible(true);
    }
    @FXML
    public void showFavoriteList(){
        movieListView.setVisible(false);
        userListView.setVisible(true);
        favoriteListView.setVisible(true);
    }
}
