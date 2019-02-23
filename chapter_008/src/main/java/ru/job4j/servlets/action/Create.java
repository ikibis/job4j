package ru.job4j.servlets.action;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Create implements Action {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
    private AtomicInteger identifier = new AtomicInteger(0);
    @Override
    public boolean doAction(ValidateService validateService, Map<String, String[]> map) {
        boolean result = false;
        String date = sdf.format(new Date());
        User user = new User(identifier.getAndIncrement(),
                map.get("name")[0],
                map.get("login")[0],
                map.get("password")[0],
                map.get("email")[0], date);
        if (validateService.add(user)) {
            result = true;
        }
        return result;
    }

    @Override
    public List<User> findAll(ValidateService validateService) {
        return null;
    }

}


