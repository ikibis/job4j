package ru.job4j.store;

public class Info {
    public int howMuchDeleted(Store store) {
        int result = store.previous.size() - this.howMuchSetted(store);
        return result > 0 ? result : 0;
    }

    public int howMuchNew(Store store) {
        int result = store.current.size() - this.howMuchSetted(store);
        return result > 0 ? result : 0;
    }

    public int howMuchSetted(Store store) {
        return store.setted;
    }
}
