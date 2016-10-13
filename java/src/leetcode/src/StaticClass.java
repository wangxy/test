package main.java.algorithms.src;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwang on 7/8/16.
 */
public class StaticClass {
    private static final Map<String, String> FORMAT_TO_PATTERN = new HashMap<String, String>();
    static {
        FORMAT_TO_PATTERN.put("/yyyy/MM/dd/HH/", "/\\d{4}/\\d{2}/\\d{2}/\\d{2}/");
        FORMAT_TO_PATTERN.put("/yyyy/MM/dd/", "/\\d{4}/\\d{2}/\\d{2}/");
    }

    String name;
    public StaticClass(String x) {
        name = x;
        for (String key : FORMAT_TO_PATTERN.keySet()) {
            System.out.println(FORMAT_TO_PATTERN.get(key));
        }
    }

}
