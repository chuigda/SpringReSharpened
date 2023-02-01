package tech.icey.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumUtil {
    public static <T> List<T> enumerate(Class<T> e) {
        return Arrays.stream(e.getEnumConstants())
                .collect(Collectors.toList());
    }
}
