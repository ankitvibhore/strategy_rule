package com.strategy;

@FunctionalInterface
public interface Condition {

    boolean evaluate(NodeMap nodeMap);

    Condition FALSE = nodes -> false;
    Condition TRUE = nodes -> true;
}
