package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by xwang on 10/3/16.
 */
public class DependentTask {

    private static class Task {
        int id;
        Task[] require;
        int completed = 0;

        Task(int id, Task[] require) {
            this.id = id;
            this.require = require;
        }

        public boolean ready(){
            if (this.require == null || this.require.length == 0) { return true; }
            return this.require.length == completed;
        }

        // Update the done Counter if current task depends on a given task.
        public void update(Task doneTask) {
            if (this.require == null) { return; }
            for (int i = 0; i < require.length; i++) {
                if (require[i] == doneTask) {
                    completed++;
                    return;
                }
            }
        }

        public void execute() {
            System.out.println("Hi, I am here: " + id);
        }
    }

    private synchronized Task getReady(){
        Task res = null;
        if (tasks.size() == 0) { return null; }
        for (Task t: tasks) {
            if (t.ready()) {
                res = t;
                break;
            }
        }
        if (res != null) {
            tasks.remove(res);
        }
        return res;
    }

    private synchronized void updateDepends(Task done) {
        for (Task t : tasks) {
            t.update(done);
        }
    }
    Random r = new Random();

    private class RunningTask implements Runnable {
        private List<Task> pending;
        RunningTask(List<Task> T) {
            pending = T;
        }

        @Override
        public void run() {
            Task toRun = null;
            while (tasks.size() > 0) {
                toRun = getReady();
                if (toRun == null) {
                    try {
                        Thread.sleep(Math.abs(r.nextInt()) % 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    toRun.execute();
                    updateDepends(toRun);
                }
            }
        }
    }

    private List<Task> tasks;
    public void process(List<Task> tasks, int maxThreads) {
        this.tasks = tasks;
        Thread[] T = new Thread[maxThreads];
        for (int i = 0; i < maxThreads; i++) {
            Thread t = new Thread(new RunningTask(tasks));
            T[i] = t;
            t.start();
        }

        for (int i = 0; i < maxThreads; i++) {
            try {
                T[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Task prev = null;
        List<Task> all = new ArrayList<Task>();
        // create a chain of tasks
        for (int i = 0; i < 10; i++) {
            Task cur = null;
            if (i % 3 == 0) {
                cur = new Task(i, (prev == null ? null : new Task[]{prev}));
            } else {
                cur = new Task(i, null);
            }

            // 0, 3 -> 2
            // 1,
            // 2,
            // 4,
            // 5, 6 -> 5
            // 7,
            // 8
            // 9, 9 -> 8
            all.add(cur);
            prev = cur;
        }
         DependentTask dt = new DependentTask();

          dt.process(all, 3);

    }
}
