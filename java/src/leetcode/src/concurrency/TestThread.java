package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by xwang on 5/23/16.
 */
public class TestThread implements Runnable {
    ConcurrentHashMap map = new ConcurrentHashMap();
    private String msg;
    TestThread(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        TestThread ping = new TestThread("ping");
        TestThread pong = new TestThread("pong");

        Thread x = new Thread(ping);
        Thread y = new Thread(pong);
        x.start();
        y.start();
        try {
            x.join();
            y.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
