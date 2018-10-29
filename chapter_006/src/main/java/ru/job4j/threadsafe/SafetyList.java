package ru.job4j.threadsafe;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DynamicArrayList;

import java.util.Iterator;
@ThreadSafe
public class SafetyList<T> implements Iterable<T> {
    @GuardedBy("this")
    DynamicArrayList<T> safetyList;
    public SafetyList() {
        this.safetyList = new DynamicArrayList<>();
    }
    public void add(T item) {
        safetyList.add(item);
    }
    private synchronized DynamicArrayList copy(DynamicArrayList list) {
        DynamicArrayList result = new DynamicArrayList();
        for (Object element : list) {
            result.add(element);
        }
        return result;
    }
    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.safetyList).iterator();
    }
}
