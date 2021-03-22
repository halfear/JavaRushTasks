package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        private static final AtomicInteger factoryCount = new AtomicInteger(0);
        private final AtomicInteger threadCount = new AtomicInteger(0);
        private final ThreadGroup group;
        private final String namePrefix;

        public AmigoThreadFactory() {
            group = Thread.currentThread().getThreadGroup();
            namePrefix = group.getName() +
                    "-pool-" +
                    factoryCount.incrementAndGet() +
                    "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread resultThread = new Thread(group, r, namePrefix + threadCount.incrementAndGet());
            if (resultThread.isDaemon())
                resultThread.setDaemon(false);
            if (resultThread.getPriority() != Thread.NORM_PRIORITY)
                resultThread.setPriority(Thread.NORM_PRIORITY);

            return resultThread;
        }
    }
}
