package multithread.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by king_luffy on 2018/9/27.
 */
public class DeadLockSearch {

    public static void main(String[] args) throws InterruptedException {
        scanDeadLock();
    }

    public static void scanDeadLock() throws InterruptedException {
        final ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long[] ids = mxBean.findDeadlockedThreads();
                System.out.println("扫描死锁...");
                if (ids != null) {
                    ThreadInfo[] threadInfos = mxBean.getThreadInfo(ids);
                    for (ThreadInfo threadInfo : threadInfos) {
                        System.out.println(threadInfo);
                    }
                }
            }
        };
//        Runnable runnable = () -> {
//            long[] ids = mxBean.findDeadlockedThreads();
//            System.out.println("扫描死锁...");
//            if (ids != null) {
//                ThreadInfo[] threadInfos = mxBean.getThreadInfo(ids);
//                for (ThreadInfo threadInfo : threadInfos) {
//                    System.out.println(threadInfo);
//                }
//            }
//        };
//
//        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5, Executors.defaultThreadFactory());
//        executorService.scheduleAtFixedRate(runnable, 1, 5, TimeUnit.SECONDS);

        Thread t = new Thread(runnable);
        t.start();
        Thread.sleep(5000);
        System.out.println("end");
    }
}
