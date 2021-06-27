package com.strategy;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractRuleFactory {

    private static final List<String> ALLOWED_COMPOSITE_RULE_TYPES = Arrays.asList(
            UnitRuleGroup.class.getSimpleName(),
            ConditionalRuleGroup.class.getSimpleName(),
            ActivationRuleGroup.class.getSimpleName());

    protected Rule createRule(RuleDefinition ruleDefinition)
    {
        if (ruleDefinition.isCompositeRule())
        {
            return createCompositeRule(ruleDefinition);
        }
        else {
            return createSimpleRule(ruleDefinition);
        }
    }

    protected abstract Rule createSimpleRule(RuleDefinition ruleDefinition);

    protected Rule createCompositeRule(RuleDefinition ruleDefinition)
    {
        if (ruleDefinition.getCondition() != null) {
            System.out.println("rule condition ignored");
        }
        if (ruleDefinition.getActions() != null && !ruleDefinition.getActions().isEmpty()) {
            System.out.println("rule action ignored");
        }
        CompositeRule compositeRule;
        String name = ruleDefinition.getName();
        switch (ruleDefinition.getCompositeRuleType()) {
            case "UnitRuleGroup":
                compositeRule = new UnitRuleGroup(name);
                break;
            case "ActivationRuleGroup":
                compositeRule = new ActivationRuleGroup(name);
                break;
            case "ConditionalRuleGroup":
                compositeRule = new ConditionalRuleGroup(name);
                break;
            default:
                throw new IllegalArgumentException("Invalid composite rule type, must be one of " + ALLOWED_COMPOSITE_RULE_TYPES);
        }
        compositeRule.setDescription(ruleDefinition.getDescription());
        compositeRule.setPriority(ruleDefinition.getPriority());

        for (RuleDefinition composingRuleDefinition : ruleDefinition.getComposingRules()) {
            compositeRule.addRule(createRule(composingRuleDefinition));
        }

        return compositeRule;
    }

}
