package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static volatile AtomicInteger threadPriorityCount = new AtomicInteger(1);

    private synchronized void setThreadPriority() {
        int currentPriority = threadPriorityCount.getAndIncrement();
        currentPriority = getThreadGroup() != null && currentPriority > getThreadGroup().getMaxPriority()
                ? getThreadGroup().getMaxPriority()
                : currentPriority;
        if(threadPriorityCount.intValue() > MAX_PRIORITY) {
            threadPriorityCount.set(1);
        }
        setPriority(currentPriority);
    }

    public MyThread() {
        super();
        setThreadPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setThreadPriority();
    }

    public MyThread(String name) {
        super(name);
        setThreadPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setThreadPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setThreadPriority();
    }
}
