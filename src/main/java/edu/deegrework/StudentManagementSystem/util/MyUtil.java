package edu.deegrework.StudentManagementSystem.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyUtil {
    public static <T> List<String> getFieldNames(Class<T> clazz) {
        return Arrays
                .stream(clazz.getFields())
                .map(Field::getName)
                .collect(Collectors.toList());
    }
}
