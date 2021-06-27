package com.strategy;

import java.util.ArrayList;
import java.util.List;

public class RuleDefinition {

    private String name = Rule.DEFAULT_NAME;
    private String description = Rule.DEFAULT_DESCRIPTION;
    private int priority = Rule.DEFAULT_PRIORITY;
    private String condition;
    private List<String> actions = new ArrayList<>();
    private List<RuleDefinition> composingRules = new ArrayList<>();
    private String compositeRuleType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public List<RuleDefinition> getComposingRules() {
        return composingRules;
    }

    public void setComposingRules(List<RuleDefinition> composingRules) {
        this.composingRules = composingRules;
    }

    public String getCompositeRuleType() {
        return compositeRuleType;
    }

    public void setCompositeRuleType(String compositeRuleType) {
        this.compositeRuleType = compositeRuleType;
    }

    public boolean isCompositeRule()
    {
        return !composingRules.isEmpty();
    }
}
