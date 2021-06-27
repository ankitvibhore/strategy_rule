package com.strategy;

import java.util.*;
import java.util.function.Consumer;

public class NodeMap implements Iterable<Nodes<?>>{

    private final Set<Nodes<?>> nodes = new HashSet<>();


    public <T> void put(String name, T value) {
        Objects.requireNonNull(name, "fact name must not be null");
        Objects.requireNonNull(value, "fact value must not be null");
        Nodes<?> retrievedNode = getNode(name);
        if (retrievedNode != null) {
            remove(retrievedNode);
        }
        add(new Nodes<>(name, value));
    }

    public <T> void add(Nodes<T> node) {
        Objects.requireNonNull(node, "fact must not be null");
        Nodes<?> retrievedNode = getNode(node.getName());
        if (retrievedNode != null) {
            remove(retrievedNode);
        }
        nodes.add(node);
    }

    public void remove(String nodeName) {
        Objects.requireNonNull(nodeName, "fact name must not be null");
        Nodes<?> node = getNode(nodeName);
        if (node != null) {
            remove(node);
        }
    }

    public <T> void remove(Nodes<T> node) {
        Objects.requireNonNull(node, "fact must not be null");
        nodes.remove(node);
    }

    public <T> T get(String nodeName) {
        Objects.requireNonNull(nodeName, "fact name must not be null");
        Nodes<?> node = getNode(nodeName);
        if (node != null) {
            return (T) node.getValue();
        }
        return null;
    }


    public Nodes<?> getNode(String nodeName) {
        Objects.requireNonNull(nodeName, "fact name must not be null");
        return nodes.stream()
                .filter(node -> node.getName().equals(nodeName))
                .findFirst()
                .orElse(null);
    }

    public Map<String, Object> asMap() {
        Map<String, Object> map = new HashMap<>();
        for (Nodes<?> node : nodes) {
            map.put(node.getName(), node.getValue());
        }
        return map;
    }



    @Override
    public Iterator<Nodes<?>> iterator() {
        return nodes.iterator();
    }

    @Override
    public String toString() {
        Iterator<Nodes<?>> iterator = nodes.iterator();
        StringBuilder stringBuilder = new StringBuilder("[");
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().toString());
            if (iterator.hasNext()) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void clear()
    {
        nodes.clear();
    }
}
