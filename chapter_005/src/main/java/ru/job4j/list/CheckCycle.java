package ru.job4j.list;

public class CheckCycle {
    boolean hasCycle(Node first) {
        Node elementNow = first;
        Node elementNext = first;
        boolean result = false;
        while (first != null) {
            elementNow = elementNow.next;
            if (elementNext.next != null) {
                elementNext = elementNext.next.next;
            } else {
                result = false;
                break;
            }
            if ((elementNow == null) || (elementNext == null)) {
                result = false;
                break;
            }
            if (elementNext == elementNow) {
                result = true;
                break;
            }
        }
        return result;
    }
}

