package com.example.ViewModels;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.Model.Observer;
import com.example.Model.Subject;
import com.example.Model.Team;
import com.example.Views.EditorView;
import com.example.Views.ScoreboardView;

public class ScoreboardViewModel implements Subject {
    private ArrayList<Observer> observers;
    private ArrayList<Team> teams;
    private int TEAMNAMEMAX = 50;
    private int TEAMNAMEMIN = 5;
    private int TEAMSCOREMIN = 0;
    private int TEAMSCOREMAX = 2000;

    public ScoreboardViewModel() {
        observers = new ArrayList<Observer>();
        teams = new ArrayList<Team>();
        setScoreboard();
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void updateTeam(Team updatedTeam, String teamName, String teamScore) {
        if (teamNameCheck(teamName)) {
            updatedTeam.setTeamName(teamName);
            updatedTeam.setIsUpdated(true);
            updatedTeam.setDate();
        }
        if (teamScoreCheck(teamScore)) {
            updatedTeam.setScore(Integer.parseInt(teamScore));
            updatedTeam.setIsUpdated(true);
            updatedTeam.setDate();
        }
        notifyObserver();
    }

    public void registerObeserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        Observer editorObserver = null;

        for (Observer currObsvr : observers) {
            if ((currObsvr instanceof EditorView) && ((EditorView) currObsvr).getTeam().getIsUpdated()) {
                currObsvr.update();
                editorObserver = currObsvr;
            } else if (currObsvr instanceof ScoreboardView) {
                currObsvr.update();
            }
        }
        if (editorObserver != null) {
            ((EditorView) editorObserver).getTeam().setIsUpdated(false);
        }
    }

    public Boolean teamNameCheck(String teamName) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(teamName);

        if (teamName.length() < TEAMNAMEMIN || teamName.length() > TEAMNAMEMAX)
            return false;

        if (matcher.find())
            return false;

        return true;
    }

    public Boolean teamScoreCheck(String teamScore) {
        try {
            int score = Integer.parseInt(teamScore);
            if (score > TEAMSCOREMAX || score < TEAMSCOREMIN)
                return false;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    public void setScoreboard() {
        teams.add(new Team());
        teams.add(new Team());
        teams.add(new Team());
        teams.add(new Team());
        teams.add(new Team());
    }
}
