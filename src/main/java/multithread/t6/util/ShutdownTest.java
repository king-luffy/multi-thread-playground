package multithread.t6.util;

import multithread.util.SleepUtils;

/**
 * Created by king_luffy on 2018/7/25.
 */
public class ShutdownTest extends Shutdownable{

    @Override
    protected void process() {
        System.out.println("process");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ShutdownTest shutdownTest = new ShutdownTest();
        Thread thread = new Thread(shutdownTest);
        thread.start();
        SleepUtils.secondPrint(2);
        shutdownTest.cancel();
        SleepUtils.secondPrint(2);
    }
}
