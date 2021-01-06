package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread targetThread;

    public LoggingStateThread(Thread target) {
        targetThread = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State state = null;
        while (state != State.TERMINATED) {
            Thread.State currentState;
            if ((currentState = targetThread.getState()) != state) {
                System.out.println(currentState);
                state = currentState;
            }
        }
    }
}
