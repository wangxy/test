package main.java.algorithms.src.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by xwang on 6/29/16.
 */
public class SemaphoreMutexTest {
    static Random r = new Random();

    static List<String> produces = new ArrayList<String>();
    static Semaphore sem = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);
    static int cnt = 0;

    static class Producer extends Thread {
        public void run(){
            try {
                while (true) {
                    mutex.acquire();
                    cnt++;
                    System.out.println("Produce" + cnt);
                    produces.add(String.valueOf(cnt));
                    mutex.release();
                    sem.release();
                    sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Consumer extends Thread {
        private String name;
        Consumer(String name) {
            this.name = name;
        }
        public void run() {
            try {
                while(true) {
                    sem.acquire();
                    mutex.acquire();
                    for (String l : produces) {
                        System.out.println(this.name + ": " + l);
                    }
                    produces.clear();
                    // producer can produce more
                    mutex.release();
                    sleep(Math.abs(r.nextInt()) % 10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args){
        Producer p = new Producer();
        Consumer g = new Consumer("Google");
        Consumer a = new Consumer("Amazon");
        Consumer f = new Consumer("Facebook");
        p.start();
        g.start();
        a.start();
        f.start();

    }
}
