package main.java.algorithms.src.prototype;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xwang on 6/21/16.
 */
public class RegexTests {

    public static void main(String[] args) {
        // possible values, 0-9, 10-99, 100-199, 200-255

        ConcurrentHashMap<String, String> x = new ConcurrentHashMap<String, String>();

        Pattern pattern = Pattern.compile("(([0-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}([0-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])");
        String[] ips = new String[] {"0.0.0.0", "10", "100", "255", "01", "255.255.1.12", "249"};

        for (String ip : ips) {
            Matcher m = pattern.matcher(ip);
            if (m.find()) {
                System.out.println(ip + ": true");
                System.out.println(m.group(0));
            } else {
                System.out.println(ip + ": false");
            }
        }
    }
}
