package com.janbask.training3;

public class ThreadJoin {
    public static void main(String[] args) {

        //Simple Join joins the execution context of 2 threads, the subsequent statements are executed after the joint operations finish
        Thread joinedThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<=999; i++){
                    System.out.printf("\nBackgroundThread1 CurrentWork: %s", i);
                }
                System.out.println("\nBackground1 Finished work!");
            }
        });
        Thread joinedThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<=999; i++){
                    System.out.printf("\nBackgroundThread2 CurrentWork: %s", i);
                }
                System.out.println("\nBackground2 Finished work!");
            }
        });
        joinedThread1.start();
        joinedThread2.start();
        System.out.println("This message would be lost!");
        try {
            joinedThread1.join();
            joinedThread2.join();
            System.out.println("This message would not be lost!");
        }
        catch (InterruptedException interruptedException){
            System.out.printf("The thread was interrupted: %s", interruptedException.getMessage());
        }
        System.out.println("This message would be printed after the thread finishes - because of join");
    }
}
