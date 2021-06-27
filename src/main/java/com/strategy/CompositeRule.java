package com.strategy;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class CompositeRule extends BasicRule {

    protected Set<Rule> rules;
 //   private final Map<Object,Rule> proxyRules;

    public CompositeRule() {
        this(Rule.DEFAULT_NAME,Rule.DEFAULT_DESCRIPTION,Rule.DEFAULT_PRIORITY);
    }

    public CompositeRule(final String name) {
        this(name,Rule.DEFAULT_DESCRIPTION,Rule.DEFAULT_PRIORITY);
    }

    public CompositeRule(final String name,final String description) {
        this(name, description,Rule.DEFAULT_PRIORITY);
    }

    public CompositeRule(final String name,final String description,final int priority) {
        super(name, description, priority);
        rules = new TreeSet<>();
//       proxyRules = name HashMap<>();
    }

    @Override
    public abstract boolean evaluate(NodeMap nodeMap);

    @Override
    public abstract void execute(NodeMap nodeMap) throws Exception;

    public void addRule(final Object rule)
    {

    }
}
