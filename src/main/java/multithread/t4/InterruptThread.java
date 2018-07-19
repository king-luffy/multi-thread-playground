package multithread.t4;

import multithread.util.SleepUtils;

/**
 * Created by king_luffy on 2018/5/24.
 */
public class InterruptThread {

    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        //睡眠5s，使两个线程充分运行
        SleepUtils.secondPrint(5);

        //线程中断
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("Sleep Thread is interrupted "+ sleepThread.isInterrupted());
        System.out.println("Busy Thread is interrupted "+ busyThread.isInterrupted());

        SleepUtils.secondPrint(2);
    }

    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while(true){
                SleepUtils.second(10);
            }
        }

    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){}
        }
    }
}
