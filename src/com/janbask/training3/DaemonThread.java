package com.janbask.training3;

public class DaemonThread extends Thread {
    public void run(){
        //ToDo: create a good example of Deamon threads that can demo that the daemon thread gets terminated automatically when user threads are finished.
        if(Thread.currentThread().isDaemon()){//checking for daemon thread
            System.out.println("daemon thread work");
        }
        else{
            System.out.println("user thread work");
        }
    }
    public static void main(String[] args){
        DaemonThread t1=new DaemonThread();//creating thread
        DaemonThread t2=new DaemonThread();
        DaemonThread t3=new DaemonThread();

        t1.setDaemon(true);//now t1 is daemon thread

        t1.start();//starting threads
        t2.start();
        t3.start();
    }
}
