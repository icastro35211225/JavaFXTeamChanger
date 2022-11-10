package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class View implements Initializable {
    private final ObservableList<Team> teams = FXCollections.observableArrayList();

    @FXML
    private ListView<Team> myListView;
    private TextField myName;
    private TextField myScore;
    private TextField myDate;

    public void initialize(URL url, ResourceBundle rb) {
        teams.clear();
        // myName.setText("test");
        myListView.setItems(teams);
        myListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        setScoreboard();
        myListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("You clicked on" +
                        myListView.getSelectionModel().getSelectedItem());

                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Editor.fxml"));
                    // Create editorview object, make it into objects
                    // new editor object
                    // set loader's controller with new editor object
                    // set editor's team data
                    // set model view to (HAVE 2 scoreboard and team editor)
                    Scene scene = new Scene(loader.load());
                    // ViewModel con = loader.getController();
                    Stage stage = new Stage();
                    stage.setTitle("Team Editor");
                    stage.setScene(scene);

                    stage.show();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        });
    }

    public void setScoreboard() {
        teams.add(new Team("Highly Irresistable Lions", 45));
        teams.add(new Team("Immovalbe Tigers", 75));
        teams.add(new Team("Super Duper Bears", 100));
        teams.add(new Team("Imcomparable Ottters", 30));
        teams.add(new Team("Resplendent Ocelots", 8));
    }

}