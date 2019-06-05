package ru.job4j.tdd;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {
    private static final Pattern PATTERN = Pattern.compile("\\$\\{(\\w+)\\}");

    @Override
    public String generate(String template, Map<String, String> data) throws KeysException {
        Matcher matcher = PATTERN.matcher(template);
        Set<String> set = new HashSet<>();
        while (matcher.find()) {
            String searchedKey = template.substring(matcher.start() + 2, matcher.end() - 1);
            set.add(searchedKey);
            String valueToPaste = data.get(searchedKey);
            if (valueToPaste == null) {
                throw new KeysException("Not enough keys in the data Map");
            }
            template = matcher.replaceFirst(valueToPaste);
            matcher = PATTERN.matcher(template);
        }
        if (set.size() < data.size()) {
            throw new KeysException("Too many keys in the data Map");
        }
        return template;
    }
}