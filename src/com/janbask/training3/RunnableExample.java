package com.janbask.training3;

public class RunnableExample {

    public static void main(String[] args) {
        runThreads();
    }

    static void runThreads(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<=99999; i++)
                    System.out.printf("\nThis is thread1 - value of counter: %s", i);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<=99999; i++)
                    System.out.printf("\nThis is thread2 - value of counter: %s", i);
            }
        });
        thread1.start();
        thread2.start();
    }
}
