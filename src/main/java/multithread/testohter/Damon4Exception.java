package multithread.testohter;

import multithread.util.TimeHelper;

/**
 * Created by king_luffy on 2018/7/5.
 */
public class Damon4Exception {

    int number =1;
    int numberEx = 0;

    public void normalHandle(){
        if(handleWithCode(number)==1){
            System.out.println();
        }else{
            System.out.println();
        }
    }
    public int handleWithCode(int src){
        if(src==0)
            return -1;
        else
            return 1;
    }

    public void noExceptionHandle(){
        try {
            verify(number);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exceptionHandle(){
        try {
            verify(numberEx);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verify(int src) throws Exception {
        if(src==0){
            throw new Exception("非法数据");
        }
    }


    public static void main(String[] args) {
        TimeHelper timeHelper = new TimeHelper();
        timeHelper.begin();
        for(int i=0;i<100000;i++){
            new Damon4Exception().normalHandle();
        }
        String end1 = timeHelper.end();

        timeHelper = new TimeHelper();
        timeHelper.begin();
        for(int i=0;i<100000;i++){
            new Damon4Exception().noExceptionHandle();
        }
        String end2 = timeHelper.end();

        timeHelper = new TimeHelper();
        timeHelper.begin();
        for(int i=0;i<100000;i++){
            new Damon4Exception().exceptionHandle();
        }
        String end3 = timeHelper.end();

        System.out.println(end1);
        System.out.println(end2);
        System.out.println(end3);
    }
}
