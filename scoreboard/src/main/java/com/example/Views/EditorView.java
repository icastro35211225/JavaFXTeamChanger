package com.example.Views;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.Observer;
import com.example.Team;
import com.example.ViewModels.ScoreboardViewModel;

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

    public void initialize() {
        scoreboardViewModel.registerObeserver(this);
        update();
    }

    @FXML
    void onSaveClick(ActionEvent event) {
        scoreboardViewModel.updateTeam(team, myName.getText(), myScore.getText());
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setModelView(ScoreboardViewModel scoreboardView) {
        this.scoreboardViewModel = scoreboardView;
    }

    public void setTeamName() {
        this.myName.setText(team.getTeamName());
    }

    public void setTeamScore() {
        this.myScore.setText(Integer.toString(team.getScore()));

    }

    public void setTeamDate() {
        team.setDate();
        this.myDate.setText(team.getModifiedDate());
    }

    public void update() {
        setTeamName();
        setTeamScore();
        setTeamDate();
    }

}
