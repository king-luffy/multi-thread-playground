package multithread.t6;

import multithread.util.SleepUtils;

/**
 * Created by king_luffy on 2018/5/28.
 */
public class ShutdownThread {

    public static void main(String[] args) {
        Runner one = new Runner();
        Thread countThread = new Thread(one,"CountThread");
        countThread.start();

        SleepUtils.secondPrint(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two,"CountThread2");
        countThread.start();

        SleepUtils.secondPrint(1);
        two.cancel();

        SleepUtils.secondPrint(5);
    }

    private static class Runner implements Runnable{

        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            SleepUtils.printTime();
            while(on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            SleepUtils.printTime();
            System.out.println("Count i= " + i);
        }

        public void cancel(){
            on = false;
        }
    }
}
