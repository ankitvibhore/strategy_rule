package com.strategy;

import org.dom4j.Node;
import org.dom4j.rule.Action;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import java.io.Serializable;

public class RuleAction implements ActionInteface {

    private final String expression;
    private final Serializable compiledExpression;

    public RuleAction(String expression) {
        this.expression = expression;
        compiledExpression = MVEL.compileExpression(expression);
    }

    public RuleAction(String expression, ParserContext parserContext)
    {
        this.expression = expression;
        compiledExpression = MVEL.compileExpression(expression,parserContext);
    }



    @Override
    public void execute(NodeMap nodeMap) throws Exception {
        try{
            MVEL.executeExpression(compiledExpression,nodeMap.asMap());
        }
        catch (Exception e)
        {
            throw e;
        }

    }
}
