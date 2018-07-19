package multithread.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by king_luffy on 2018/5/24.
 */
public class SleepUtils {

    public static void secondPrint(int sec){
        try {
            for(int i= 0;i<sec;i++){
                System.out.println(getThreadRunAtTime());
                TimeUnit.SECONDS.sleep(1);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static void second(int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static void printTime(){
        System.out.println(getThreadRunAtTime());
    }

    public static String getThreadName(){
        return Thread.currentThread().getName();
    }

    public static String getThreadRunAtTime(){
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        return String.format("[%s] Run at %s",getThreadName(),format.format(new Date()));
    }
}
