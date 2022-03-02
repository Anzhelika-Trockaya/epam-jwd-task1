package com.epam.task1.observer;

import com.epam.task1.entity.CustomArray;

import java.util.EventObject;

public class CustomArrayEvent extends EventObject {
    public CustomArrayEvent(CustomArray source) {
        super(source);
    }

    public CustomArray getSource() {
        return (CustomArray) super.getSource();
    }
}
