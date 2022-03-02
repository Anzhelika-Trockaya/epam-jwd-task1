package com.epam.task1.observer;

public interface CustomArrayObservable {
    void attach(CustomArrayObserver observer);

    void detach();

    void notifyObserver();
}
