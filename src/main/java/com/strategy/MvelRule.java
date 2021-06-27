package com.strategy;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import java.util.ArrayList;
import java.util.List;

public class MvelRule extends BasicRule {

    private Condition condition = Condition.FALSE;
    private final List<ActionInteface> actions = new ArrayList<>();
    private final ParserContext parserContext;

    public MvelRule(ParserContext parserContext) {
        super(Rule.DEFAULT_NAME,Rule.DEFAULT_DESCRIPTION);
        this.parserContext = parserContext;
    }

    public MvelRule() {
        this(new ParserContext());
    }

    public MvelRule name(String name)
    {
        this.name = name;
        return this;
    }
    public MvelRule description(String description)
    {
        this.description = description;
        return this;
    }
    public MvelRule priority(int priority)
    {
        this.priority = priority;
        return this;
    }

    public MvelRule when(String condition)
    {
        this.condition = new MVELCondition(condition,parserContext);
        return this;
    }

    public MvelRule then(String action)
    {
        this.actions.add(new RuleAction(action,parserContext));
        return this;
    }

    @Override
    public boolean evaluate(NodeMap nodeMap) {
        return condition.evaluate(nodeMap);
    }

    @Override
    public void execute(NodeMap nodeMap) throws Exception {
        for (ActionInteface action: actions)
        {
            action.execute(nodeMap);
        }
    }
}
