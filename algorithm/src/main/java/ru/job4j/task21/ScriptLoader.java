package ru.job4j.task21;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class ScriptLoader {

    List load(Map<Integer, List<Integer>> ds, Integer scriptId) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> scriptsStack = new Stack<>();
        scriptsStack.push(scriptId);
        while (!scriptsStack.empty()) {
            int element = scriptsStack.pop();
            result.add(element);
            ds.get(element).forEach(scriptsStack::push);
        }
        return result.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }
}
