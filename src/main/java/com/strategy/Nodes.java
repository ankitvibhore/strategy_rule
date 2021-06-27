package com.strategy;

import java.util.Objects;

public class Nodes<T> {

    private final String name;
    private final T value;

    public Nodes(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodes<?> nodes = (Nodes<?>) o;
        return name.equals(nodes.name) && value.equals(nodes.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
