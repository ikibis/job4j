package ru.job4j.srp.simple.actions;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static final ActionFactory FACTORY = new ActionFactory();
    private Map<String, Action> actionMap = new HashMap<>();

    {
        actionMap.put("+", new Add());
        actionMap.put("-", new Subtract());
        actionMap.put("/", new Div());
        actionMap.put("*", new Multiple());
    }

    public static ActionFactory getInstance() {
        return FACTORY;
    }

    public Map<String, Action> getActionMap() {
        return this.actionMap;
    }

    public double calculate(String action, double first, double second) {
        return actionMap.getOrDefault(action, new UnknownAction()).compute(first, second);
    }

    class UnknownAction implements Action {
        @Override
        public double compute(double first, double second) {
            return 0;
        }
    }
}
