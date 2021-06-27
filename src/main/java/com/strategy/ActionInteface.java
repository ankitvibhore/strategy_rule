package com.strategy;

@FunctionalInterface
public interface ActionInteface {

    void execute(NodeMap nodeMap) throws Exception;
}
