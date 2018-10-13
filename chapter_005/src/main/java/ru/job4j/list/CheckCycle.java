package ru.job4j.list;

public class CheckCycle {
    boolean hasCycle(Node first) {
        boolean result;
        Node tortoise = first;
        Node hare = first;
        while (true) {
            tortoise = tortoise.next;
            if (first == null) {
                result = false;
                break;
            }
            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                result = false;
                break;
            }
            if ((tortoise == null) || (hare == null)) {
                result = false;
                break;
            }
            if (tortoise == hare) {
                result = true;
                break;
            }
        }
        return result;
    }
}
