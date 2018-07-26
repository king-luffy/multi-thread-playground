package multithread.util;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by king_luffy on 2017/9/20.
 */
public class TimeHelper {

    private static final Logger logger = Logger.getLogger(TimeHelper.class);

    private Date beginTime;
    private long stamp;

    public void begin(){
        beginTime = new Date();
        stamp = beginTime.getTime();
        System.out.println("Begin stamp("+ stamp+")");
        logger.info("Begin stamp("+ stamp+")");
    }

    public String end(){
        Date now = new Date();
        long duration = now.getTime() - beginTime.getTime();
        System.out.println("End stamp("+stamp+"). Time duration is : "+duration+" ms");
        logger.info("End stamp("+stamp+"). Time duration is : "+duration+" ms");
        return duration+" ms";
    }

    public static String nowTime(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void logNowTime(){
        System.out.println(nowTime());
        logger.info(nowTime());
    }

}
