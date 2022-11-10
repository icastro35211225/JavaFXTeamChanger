package com.example;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ScoreboardController {
    private final ObservableList<Team> teams = FXCollections.observableArrayList();

    @FXML
    private ListView<Team> myListView;

    public void initialize() {
        teams.clear();
        myListView.setItems(teams);
        myListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        myListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            // do your stuff
            public void handle(MouseEvent event) {
                System.out.println("you cloicked on" +
                        myListView.getSelectionModel().getSelectedItem());
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Editor.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 380, 200);
                    Stage stage = new Stage();
                    stage.setTitle("New Window");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    System.err.println("ERROR!!!");
                }
            }
        });
        setScoreboard();
    }

    public void setScoreboard() {
        teams.add(new Team("Highly Irresistable Lions", 45));
        teams.add(new Team("Immovalbe Tigers", 75));
        teams.add(new Team("Super Duper Bears", 100));
        teams.add(new Team("Imcomparable Ottters", 30));
        teams.add(new Team("Resplendent Ocelots", 8));
    }
}
