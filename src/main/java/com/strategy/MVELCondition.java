package com.strategy;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import java.io.Serializable;

public class MVELCondition implements Condition{

    private final Serializable compiledExpression;

    public MVELCondition(String expression) {
        compiledExpression = MVEL.compileExpression(expression);
    }

    public MVELCondition(String expression, ParserContext parserContext) {
        compiledExpression = MVEL.compileExpression(expression,parserContext);
    }


    @Override
    public boolean evaluate(NodeMap nodeMap) {
        return (boolean) MVEL.executeExpression(compiledExpression,nodeMap.asMap());
    }
}
