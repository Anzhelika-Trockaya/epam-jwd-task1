package com.epam.task1.entity;

import java.io.Serializable;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayParameters implements Serializable, Cloneable {
    private static final long serialVersionUID = -6289245971251186827L;
    private OptionalInt max;
    private OptionalInt min;
    private int sum;
    private OptionalDouble average;

    public CustomArrayParameters() {
    }

    public CustomArrayParameters(OptionalInt max, OptionalInt min, int sum, OptionalDouble average) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.average = average;
    }

    public OptionalInt getMax() {
        return max;
    }

    public void setMax(OptionalInt max) {
        this.max = max;
    }

    public OptionalInt getMin() {
        return min;
    }

    public void setMin(OptionalInt min) {
        this.min = min;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public OptionalDouble getAverage() {
        return average;
    }

    public void setAverage(OptionalDouble average) {
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        CustomArrayParameters that = (CustomArrayParameters) o;
        return sum == that.sum &&
                max.equals(that.max) &&
                min.equals(that.min) &&
                average.equals(that.average);
    }

    @Override
    public int hashCode() {
        int result = max.hashCode();
        result = result * 31 + min.hashCode();
        result = result * 31 + sum;
        result = result * 31 + average.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName());
        stringBuilder.append('{').
                append("max=").append(max).
                append(", min=").append(min).
                append(", sum=").append(sum).
                append(", average=").append(min).
                append('}');
        return stringBuilder.toString();
    }
}
