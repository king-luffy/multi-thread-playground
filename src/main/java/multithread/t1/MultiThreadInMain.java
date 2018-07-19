package multithread.t1;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by king_luffy on 2018/5/17.
 */
public class MultiThreadInMain {

    @Test
    public void multiThreadTest(){

        //线程管理软件
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("threadId:"+threadInfo.getThreadId()+";"+"threadName:"+threadInfo.getThreadName());
        }
    }
}
