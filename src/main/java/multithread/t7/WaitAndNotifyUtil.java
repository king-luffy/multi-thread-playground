package multithread.t7;


import multithread.util.SleepUtils;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by king_luffy on 2018/7/20.
 */
public class WaitAndNotifyUtil {

    private static final Logger logger = Logger.getLogger(WaitAndNotifyUtil.class);

    private boolean flag = true;
    private Object lock = new Object();

    private Runnable runBeforeWait;
    private Runnable runAfterWait;

    public WaitAndNotifyUtil(Runnable runBeforeWait, Runnable runAfterWait){
        this.runBeforeWait = runBeforeWait;
        this.runAfterWait = runAfterWait;
    }

    public void runAndWait(){
        new Thread(new Wait()).start();
    }

    public void goOn(){
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    class Wait implements Runnable {
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 未收到通知时，持续wait，同时释放了lock的锁
                try {
                    if(runBeforeWait!=null) {
                        runBeforeWait.run();
                    }
                    lock.wait();
                    if(runAfterWait!=null){
                        runAfterWait.run();
                    }
                } catch (InterruptedException e) {
                    logger.info("运行异常",e);
                }

            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run before wait:");
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " end. running @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        };
        WaitAndNotifyUtil waitAndNotify = new WaitAndNotifyUtil(runnable1,runnable2);
        waitAndNotify.runAndWait();
        waitAndNotify.runAndWait();
        SleepUtils.secondPrint(2);
        waitAndNotify.goOn();


    }
}
