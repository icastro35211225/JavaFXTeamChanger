package com.example.Model;

public interface Subject {
    public void registerObeserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObserver();
}
