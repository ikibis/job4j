package ru.job4j.generic;

public class RoleStore<T> extends AbstractStore {
    private SimpleArray<Role> storeArray;

    public RoleStore(int size) {
        this.storeArray = new SimpleArray<>(size);
    }

    @Override
    public void add(Base model) {
        storeArray.add((Role) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        if (storeArray.get(Integer.parseInt(id)) != null) {
            storeArray.set(Integer.parseInt(id), (Role) model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        if (storeArray.get(Integer.parseInt(id)) != null) {
            storeArray.delete(Integer.parseInt(id));
            result = true;
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        return storeArray.get(Integer.parseInt(id));
    }
}
