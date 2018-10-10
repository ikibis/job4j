package ru.job4j.generic;

public abstract class AbstractStore<E extends Base> implements Store<E> {
    public SimpleArray<Base> storeArray;

    public AbstractStore(int size) {
        this.storeArray = new SimpleArray<>(size);
    }

    @Override
    public void add(Base model) {
        storeArray.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        if (storeArray.get(Integer.parseInt(id)) != null) {
            storeArray.set(Integer.parseInt(id), model);
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
    public E findById(String id) {
        return (E) storeArray.get(Integer.parseInt(id));
    }
}
