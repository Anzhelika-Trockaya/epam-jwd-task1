package com.epam.task1.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Warehouse implements Serializable {
    private static final long serialVersionUID = -5897708762346652427L;
    private static Warehouse instance;
    private final Map<Integer, CustomArrayParameters> params;

    private Warehouse() {
        params = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public boolean containsId(Integer id) {
        return params.containsKey(id);
    }

    public CustomArrayParameters get(Integer id) {
        return params.get(id);
    }

    public CustomArrayParameters put(Integer id, CustomArrayParameters value) {
        return params.put(id, value);
    }

    public CustomArrayParameters remove(Integer id) {
        return params.remove(id);
    }

    public void putAll(Map<? extends Integer, ? extends CustomArrayParameters> m) {
        params.putAll(m);
    }

    public void clear() {
        params.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || (o.getClass() != this.getClass())) {
            return false;
        }
        Warehouse warehouse = (Warehouse) o;
        return this.params.equals(warehouse.params);
    }

    @Override
    public int hashCode() {
        return params.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName());
        stringBuilder.append('{').append("params=").append('}');
        return stringBuilder.toString();
    }
}
