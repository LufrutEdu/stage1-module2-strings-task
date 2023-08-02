package com.epam.mjc;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringBuilder builder = new StringBuilder();
        delimiters.forEach(i -> builder.append(i).append("|"));
        builder.deleteCharAt(builder.length() - 1);
        return Arrays.stream(source.split(builder.toString()))
                .filter(Predicate.not(String::isBlank))
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.toList());
    }
}
