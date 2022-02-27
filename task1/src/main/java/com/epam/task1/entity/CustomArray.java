package com.epam.task1.entity;

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

    public CustomArray(int... elements) {
        this.elements = elements != null ? elements.clone() : null;
    }

    public int[] getElements() {
        return elements != null ? elements.clone() : null;
    }

    public void setElements(int[] elements) {
        this.elements = elements.clone();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName());
        stringBuilder.append("{elements=").append(Arrays.toString(elements)).append("}");
        return stringBuilder.toString();
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
        return Arrays.hashCode(elements);
    }
}

