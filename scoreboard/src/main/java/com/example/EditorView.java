package com.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditorView implements Observer {
    private ScoreboardViewModel scoreboardViewModel;
    private Team team;

    @FXML
    private TextField myName;

    @FXML
    private TextField myScore;

    @FXML
    private TextField myDate;

    @FXML
    private Button mySave;

    @FXML
    void onSaveClick(ActionEvent event) {
        scoreboardViewModel.updateTeam(team, myName.getText(), myScore.getText());
    }

    public void initialize(URL url, ResourceBundle rb) {
        scoreboardViewModel.registerObeserver(this);
        update();
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setModelView(ScoreboardViewModel scoreboardView) {
        this.scoreboardViewModel = scoreboardView;
    }

    public void setTeamName() {
        try {
            this.myName.setText(team.getTeamName());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void setTeamScore() {
        try {
            this.myScore.setText(Integer.toString(team.getScore()));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void setTeamDate() {
        team.setDate();
        try {
            this.myDate.setText(team.getModifiedDate());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void update() {
        setTeamName();
        setTeamScore();
        setTeamDate();
    }

}
