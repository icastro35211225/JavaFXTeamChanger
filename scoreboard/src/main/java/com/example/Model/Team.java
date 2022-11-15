package com.example.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Team {
    String teamName;
    String modifiedDate;
    int score;
    Boolean isUpdated = false;

    public Team() {
        this.teamName = "No Name Given";
        this.score = 0;
        this.isUpdated = false;
        setDate();
    }

    public Team(String teamName, int score) {
        this.teamName = teamName;
        this.score = score;
        this.isUpdated = false;
        setDate();
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.modifiedDate = formatter.format(date);
    }

    public void setIsUpdated(Boolean update) {
        this.isUpdated = update;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getScore() {
        return score;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public Boolean getIsUpdated() {
        return isUpdated;
    }

    public String toString() {
        return String.format("%-30s% 20d", teamName, score);
    }
}
