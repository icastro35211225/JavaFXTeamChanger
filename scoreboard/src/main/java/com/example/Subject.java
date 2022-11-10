package com.example;

public interface Subject {
    public void registerObeserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();
}
