package main.java.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class RunTasks {
    interface Task {
        void execute();
        // dependency() function should only return those dependencies that has not
        // been completed?
        Task[] getDependency();
    }

    public void runTasks(Task[] tasks, int maxThreads) {
        List<Thread> executor = new ArrayList<Thread>();
        for (int i = 0; i < maxThreads; i++) {
            Thread t = new Thread(new TaskExecutor());
            executor.add(t);
        }

        for (Thread t : executor) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Find the next task that has been unlocked
     * @return the next task whose all dependencies has completed.
     */
    private synchronized Task getNextTask() {
        return null; // TODO
    }

    /**
     * go through the tasks and find out whether all has been completed.
     * @return true if all tasks has been completed.
     */
    private synchronized boolean hasMoreTask(){
        return true; //TODO
    }

    private class TaskExecutor implements Runnable {
    @Override
        public void run() {
            while (true) {
                Task nextTask = getNextTask();
                if (nextTask == null) {
                    if (!hasMoreTask()) {
                        break;
                    }
                } else {
                    nextTask.execute();
                }
            }
        }
    }

    private class MyTask implements Task {
        @Override
        public void execute() {
            // do something expensive
        }

        @Override
        public Task[] getDependency() {
            // todo: return only remaining dependencies
            return new Task[0];
        }

        public boolean canRun() {
            Task[] dependency = getDependency();
            return dependency == null || dependency.length == 0;
        }
    }
}

