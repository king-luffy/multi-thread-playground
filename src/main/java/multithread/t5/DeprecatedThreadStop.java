package multithread.t5;

import multithread.util.SleepUtils;

/**
 * Created by king_luffy on 2018/5/24.
 */
public class DeprecatedThreadStop {

    public static void main(String[] args) {
        Thread printThread = new Thread(new Runner(),"printThread");
        printThread.setDaemon(true);
        printThread.start();

        SleepUtils.secondPrint(3);
        printThread.suspend();
        SleepUtils.printTime();

        SleepUtils.secondPrint(3);
        printThread.resume();
        SleepUtils.printTime();

        SleepUtils.secondPrint(3);
        SleepUtils.printTime();
        printThread.stop();

        SleepUtils.secondPrint(3);

    }

    static class Runner implements Runnable {

        @Override
        public void run() {
            SleepUtils.secondPrint(100);
        }
    }
}
