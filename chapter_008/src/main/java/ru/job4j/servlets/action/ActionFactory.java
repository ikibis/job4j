package ru.job4j.servlets.action;

import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static class Holder {
        private static final ActionFactory INSTANCE = new ActionFactory();
    }

    public static ActionFactory getInstance() {
        return Holder.INSTANCE;
    }

    private ValidateService service = new ValidateService();
    private Map<String, Action> actionMap = new HashMap<>();

    {
        actionMap.put("create", new Create());
        actionMap.put("update", new Update());
        actionMap.put("delete", new Delete());
        actionMap.put("findAll", new FindAll());
    }

    public void action(String action, HttpServletRequest req) {
        actionMap.getOrDefault(action, new UnknownAction()).doAction(service, req);
    }

    class UnknownAction implements Action {

        @Override
        public boolean doAction(ValidateService validateService, HttpServletRequest req) {
            return false;
        }
    }
}
