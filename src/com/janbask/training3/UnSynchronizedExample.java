package com.janbask.training3;

public class UnSynchronizedExample {
    static boolean addFinished = false, deductFinished = false, addFinished1 = false, deductFinished1 = false;;
    public static void main(String[] args) {
        SimpleDataAccess dataAccess = new SimpleDataAccess();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<=999; i++){
                    System.out.printf("\nAdding Value: %s", i);
                    dataAccess.addValue(i);
                }
                addFinished=true;
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<=999; i++){
                    System.out.printf("\nDeducting Value: %s", i);
                    dataAccess.deductValue(i);
                }
                deductFinished=true;
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (addFinished && deductFinished && addFinished1 && deductFinished1)
                        break;
                    else
                        System.out.printf("\nCurrent Value: %s", dataAccess.getValue());
                }
                System.out.printf("\nFinal Value: %s", dataAccess.getValue());
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<=999; i++){
                    System.out.printf("\nAdding Value: %s", i);
                    dataAccess.addValue(i);
                }
                addFinished1=true;
            }
        });
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<=999; i++){
                    System.out.printf("\nDeducting Value: %s", i);
                    dataAccess.deductValue(i);
                }
                deductFinished1=true;
            }
        });

        thread1.setPriority(1);
        thread2.setPriority(1);
        thread3.setPriority(10);
        thread4.setPriority(1);
        thread5.setPriority(1);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
