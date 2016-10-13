package main.java.algorithms.src;

import org.adrianwalker.multilinestring.Multiline;

/**
 * Created by xwang on 6/17/16.
 */
public class MultilineTest {
    // todo: this requires adding multiline to java build path and enable annotation processing.

    /**
     <html>
     <head/>
     <body>
     <p>
     Hello<br/>
     Multiline<br/>
     World<br/>
     </p>
     </body>
     </html>
     */
    @Multiline
    private static String html;

    public static void main(final String[] args) {
        System.out.println(html);
    }
}
