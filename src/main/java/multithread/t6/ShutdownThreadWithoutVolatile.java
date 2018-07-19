package multithread.t6;

import multithread.util.SleepUtils;

/**
 * Created by king_luffy on 2018/5/29.
 */

/**
 * 不可见性在新的jdk版本中
 */
public class ShutdownThreadWithoutVolatile {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while(!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 41;
        ready = true;
        SleepUtils.secondPrint(5);
    }
}
