package com.janbask.training3;

public class TerminatingThread {

    static boolean shouldTerminate=false;
    static boolean shouldTerminateChecker=false;
    static int counter = 0;
    static final int maxCounter = 99999;

    static void setShouldTerminate(boolean value){
        shouldTerminate=value;
    }

    static void setShouldTerminateChecker(boolean value){
        shouldTerminateChecker=value;
    }

    public static void main(String[] args) {
        runThreads();
    }

    static void runThreads(){
        Thread checkerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if (shouldTerminateChecker)
                        break;
                    else {
                        if (counter >= maxCounter)
                            setShouldTerminate(true);
                        else {
                            System.out.printf("\nAllowing the run: counter = %s", counter);
                            //uncomment this line to see how a thread can return control if it has nothing to do
                            //Thread.yield();

                            //uncomment the below block to see how a thread can wait if it has nothing to do
                            /*try {
                                Thread.sleep(1000);
                            }
                            catch (InterruptedException interruptedException){
                                System.out.println("Thread was interrupted: checkerThread!");
                            }*/
                        }
                    }
                }
            }
        });

        Thread workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(shouldTerminate){
                        setShouldTerminateChecker(true);
                        break;
                    }
                    else {
                        System.out.printf("\nDoing something: %s", counter);
                        counter+=1;
                    }
                }
            }
        });
        checkerThread.setPriority(10);
        workerThread.setPriority(10);
        checkerThread.start();
        workerThread.start();
    }
}
