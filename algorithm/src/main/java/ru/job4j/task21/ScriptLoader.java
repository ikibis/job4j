package ru.job4j.task21;

import java.util.*;

public class ScriptLoader {
    List load(Map<Integer, List<Integer>> ds, Integer scriptId) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<Integer> scriptsStack = new Stack<>();
        scriptsStack.push(scriptId);
        while (!scriptsStack.empty()) {
            int element = scriptsStack.pop();
            result.addFirst(element);
            ds.get(element).forEach(scriptsStack::push);
        }
        return result;
    }
}