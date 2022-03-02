package com.epam.task1.entity;

import com.epam.task1.observer.CustomArrayEvent;
import com.epam.task1.observer.CustomArrayObservable;
import com.epam.task1.observer.CustomArrayObserver;

public abstract class CustomArrayObservableImpl implements CustomArrayObservable {
    private CustomArrayObserver observer;

    @Override
    public void attach(CustomArrayObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach() {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        CustomArrayEvent event = new CustomArrayEvent((CustomArray) this);
        if (observer != null) {
            observer.updateCustomArrayParams(event);
        }
    }
}
