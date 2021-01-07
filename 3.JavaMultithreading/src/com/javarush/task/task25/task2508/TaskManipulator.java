package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        throw new UnsupportedOperationException("not to be run");
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(() -> {
            while (!thread.isInterrupted()) {
                System.out.println(thread.getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
