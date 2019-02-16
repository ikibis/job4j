package ru.job4j.servlets.storage;

import ru.job4j.servlets.model.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryStore implements Store {
    private static Store store;
    private List<User> users = new CopyOnWriteArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
    private AtomicInteger id = new AtomicInteger(0);
    public static Store getInstance() {
        if (store == null) {
            store = new MemoryStore();
        }
        return store;
    }

    @Override
    public boolean add(String name, String login, String email) {
        boolean result = true;
        String date = sdf.format(new Date());
        User user = new User(id.incrementAndGet(), name, login, email, date);
        for (User userSearched : users) {
            String userSearchedLogin = userSearched.getLogin();
            String userSearchedEmail = userSearched.getEmail();
            if (userSearchedLogin != null && userSearchedEmail != null) {
                if (userSearchedLogin.equals(user.getLogin()) || userSearchedEmail.equals(user.getEmail())) {
                    result = false;
                }
            }
        }
        if (result) {
            users.add(user);
        }
        return result;
    }

    @Override
    public boolean update(User user, String newName, String newLogin, String newEmail) {
        boolean result = false;
        if (!newName.equals(user.getName())) {
            user.setName(newName);
            result = true;
        }
        if (!newLogin.equals(user.getLogin()) && this.findByLogin(newLogin) == null) {
            user.setLogin(newLogin);
            result = true;
        }
        if (!newEmail.equals(user.getEmail()) && this.findByEmail(newEmail) == null) {
            user.setEmail(newEmail);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        return users.remove(this.findById(Integer.valueOf(id)));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        User result = null;
        for (User userSearched : users) {
            int userSearchedId = userSearched.getId();
            if (userSearchedId == id) {
                result = userSearched;
                break;
            }
        }
        return result;
    }


    public User findByLogin(String login) {
        User result = null;
        for (User userSearched : users) {
            String userSearchedLogin = userSearched.getLogin();
            if (userSearchedLogin.equals(login)) {
                result = userSearched;
                break;
            }
        }
        return result;
    }


    public User findByEmail(String email) {
        User result = null;
        for (User userSearched : users) {
            String userSearchedEmail = userSearched.getEmail();
            if (userSearchedEmail.equals(email)) {
                result = userSearched;
                break;
            }
        }
        return result;
    }
}
