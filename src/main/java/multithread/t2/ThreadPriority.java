package multithread.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by king_luffy on 2018/5/23.
 */
public class ThreadPriority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void priorityTest() throws InterruptedException {

        //建立线程
        List<Job> jobs = new ArrayList();
        for(int i=0;i<10;i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job,"Thread:"+i);
            thread.setPriority(priority);
            thread.start();
        }

        //放通所有等待的线程
        notStart = false;
        //等待10s，让所有线程开始运行，并停在第二个节点
        TimeUnit.SECONDS.sleep(10);
        //放通所有等待线程的第二个节点
        notEnd = false;

        for (Job job : jobs) {
            System.out.println("Job priority : " + job.priority + ",Count : " + job.jobCount);
        }
    }

    static class Job implements Runnable{

        //线程优先级
        private int priority;
        //线程第二个循环执行了多少次
        private long jobCount;

        public Job(int priority){
            this.priority = priority;
        }

        public void run() {
            while (notStart){
                //放弃当前线程的执行权，转给包括自己在内的其他线程执行
                Thread.yield();
            }
            while (notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }
}
