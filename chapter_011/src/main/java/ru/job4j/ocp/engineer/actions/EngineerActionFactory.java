package ru.job4j.ocp.engineer.actions;

import ru.job4j.srp.simple.actions.Action;
import ru.job4j.srp.simple.actions.ActionFactory;

import java.util.List;
import java.util.Map;

public class EngineerActionFactory extends ActionFactory {
    private static final ActionFactory FACTORY = new EngineerActionFactory();
    private Map<String, Action> actionMap = super.getActionMap();

    {
        actionMap.put("cos", new Cos());
        actionMap.put("sin", new Sin());
        actionMap.put("tg", new Tan());
        actionMap.put("ctg", new Ctg());
    }

    public static ActionFactory getInstance() {
        return FACTORY;
    }

    public double calculate(String action, List<Double> list) {
        return actionMap.getOrDefault(action, new EngineerActionFactory.UnknownAction()).compute(list);
    }

    class UnknownAction implements Action {
        @Override
        public double compute(List<Double> list) {
            return 0;
        }
    }

}
