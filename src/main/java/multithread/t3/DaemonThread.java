package multithread.t3;

import java.util.concurrent.TimeUnit;

/**
 * Created by king_luffy on 2018/5/23.
 */
public class DaemonThread {

    public static void main(String[] args) {
        daemonTest();
    }

    public static void daemonTest(){
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DaemonThread finally run");
            }
        }
    }
}
