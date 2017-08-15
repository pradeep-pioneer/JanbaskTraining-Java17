package com.janbask.training3;

public class ThreadNaming {
    public static void main(String[] args) {
        Runnable worker1 = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<=999; i++){
                    System.out.printf("\nWorking in thread - %s - Current Value: %s", Thread.currentThread().getName(), i);
                }
            }
        };
        Runnable worker2 = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<=999; i++){
                    System.out.printf("\nWorking in thread - %s - Current Value: %s", Thread.currentThread().getName(), i);
                }
            }
        };
        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);
        thread1.setName("First Thread");
        thread2.setName("Second Thread");
        thread1.start();
        thread2.start();
    }
}
