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

public class ScoreboardView implements Observer {
    private ObservableList<Team> teams = FXCollections.observableArrayList();
    ScoreboardViewModel scoreboardViewModel = new ScoreboardViewModel();
    @FXML
    private ListView<Team> myListView;

    public void initialize() {
        scoreboardViewModel.registerObeserver(this);
        teams.clear();
        myListView.setItems(teams);
        myListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        myListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            // do your stuff
            public void handle(MouseEvent event) {
                System.out.println("you clicked on" +
                        myListView.getSelectionModel().getSelectedItem());
                try {
                    Team team = myListView.getSelectionModel().getSelectedItem();

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Editor.fxml"));

                    EditorView editorView = new EditorView();
                    fxmlLoader.setController(editorView);
                    editorView.setTeam(team);
                    editorView.setModelView(scoreboardViewModel);
                    editorView.update();

                    Scene scene = new Scene(fxmlLoader.load(), 380, 200);
                    Stage stage = new Stage();
                    stage.setTitle("Team Editor");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        setScoreboard();
    }

    public void setScoreboard() {
        teams.add(new Team());
        teams.add(new Team());
        teams.add(new Team());
        teams.add(new Team());
        teams.add(new Team());
    }

    public void update() {
        teams = FXCollections.observableArrayList();
        for (Team newTeam : scoreboardViewModel.getTeams()) {
            teams.add(newTeam);
        }
        myListView.setItems(teams);
        myListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // MAYBE
        myListView.setPrefHeight(teams.size() * 24 + 2);
    }
}
