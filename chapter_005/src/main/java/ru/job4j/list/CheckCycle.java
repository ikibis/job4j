package ru.job4j.list;

public class CheckCycle {
    boolean hasCycle(Node first) {
        Node elementFirst = first;
        Node elementNow = first;
        Node elementNext = first.next;
        boolean result = false;
        while (elementNow != null && elementNext != null) {
            if (elementFirst.equals(elementNext) || elementNow.equals(elementNext)) {
                result = true;
                break;
            }
            elementNow = elementNow.next;
            elementNext = elementNext.next;
        }
        return result;
    }
}
