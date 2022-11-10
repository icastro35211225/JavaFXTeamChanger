package com.example;

import java.util.ArrayList;

public class ScoreboardViewModel implements Subject {
    private ArrayList<Observer> observers;
    private ArrayList<Team> teams;

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void updateTeam(Team team, String teamName, String teamScore) {

    }

    public void registerObeserver(Observer o) {

    }

    public void removeObserver(Observer o) {

    }

    public void notifyObserver() {

    }

}
