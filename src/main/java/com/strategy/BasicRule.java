package com.strategy;

import java.util.Objects;

public class BasicRule implements Rule{

    protected String name;
    protected String description;
    protected int priority;

    public BasicRule(final String name) {
        this(name,Rule.DEFAULT_DESCRIPTION,Rule.DEFAULT_PRIORITY);
    }

    public BasicRule(final String name,final String description) {
        this(name,description,Rule.DEFAULT_PRIORITY);
    }

    public BasicRule(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean evaluate(NodeMap nodeMap) {
        return false;
    }

    @Override
    public void execute(NodeMap nodeMap) throws Exception {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicRule basicRule = (BasicRule) o;
        if (priority != basicRule.priority)
            return false;
        if (!name.equals(basicRule.name))
            return false;
        return Objects.equals(description, basicRule.description);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = result + priority;
        return result;
    }

    @Override
    public String toString() {
        return "BasicRule{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(final Rule o) {
        if (getPriority() < o.getPriority()) {
            return -1;
        } else if (getPriority() > o.getPriority()) {
            return 1;
        } else {
            return getName().compareTo(o.getName());
        }
    }
}
