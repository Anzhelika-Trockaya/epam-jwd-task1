package com.epam.jwd.task1.entity;

import java.io.Serializable;
import java.util.Arrays;

public class CustomArray implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8688912179103625132L;
    private int[] elements;

    public CustomArray() {
        elements = new int[0];
    }

    public CustomArray(int size) {
        elements = new int[size];
    }

    public CustomArray(int... elements) {
        this.elements = elements;
    }

    public int[] getElements() {
        return elements != null ? elements.clone() : null;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
    }

    public int getElement(int index) {
        return elements[index];
    }

    public void setElement(int index, int value) {
        elements[index] = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + "elements=" + Arrays.toString(elements) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        CustomArray customArray = (CustomArray) o;
        if (customArray.elements == null || this.elements == null) {
            return this.elements == null && customArray.elements == null;
        }
        if (customArray.elements.length != this.elements.length) {
            return false;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != customArray.elements[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }
}

