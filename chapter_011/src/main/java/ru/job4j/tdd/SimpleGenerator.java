package ru.job4j.tdd;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {
    @Override
    public String generate(String template, Map<String, String> data) throws KeysException {
        Pattern pattern;
        int count = data.size();
        for (Map.Entry<String, String> element : data.entrySet()) {
            pattern = Pattern.compile("\\$\\{" + element.getKey() + "}");
            Matcher matcher = pattern.matcher(template);
            if (matcher.find()) {
                count--;
            }
            template = matcher.replaceAll(element.getValue());
        }
        Pattern patternException = Pattern.compile("\\$\\{(\\w+)\\}");
        Matcher matcherException = patternException.matcher(template);
        if (matcherException.find()) {
            throw new KeysException("Not enough keys in the data Map");
        }
        if (count > 0) {
            throw new KeysException("Too many keys in the data Map");
        }
        return template;
    }
}