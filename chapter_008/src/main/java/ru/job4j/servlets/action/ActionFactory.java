package ru.job4j.servlets.action;

import java.util.Map;

public class ActionFactory {
    public Action createAction(Map<String, String[]> map) {
        Action result = null;
        switch (map.get("action")[0]) {
            case "create":
                result = new Create();
                break;
            case "update":
                result = new Update();
                break;
            case "delete":
                result = new Delete();
                break;
            case "findAll":
                result = new FindAll();
                break;
            default:
                break;
        }
        return result;
    }
}
