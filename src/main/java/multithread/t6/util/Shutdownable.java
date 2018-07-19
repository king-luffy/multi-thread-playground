package multithread.t6.util;

/**
 * Created by king_luffy on 2018/5/29.
 */
public abstract class Shutdownable implements Runnable {

    private volatile boolean on = true;

    protected abstract void process();

    @Override
    public void run() {

        while(on && !Thread.currentThread().isInterrupted()){
            process();
        }
    }

    public void cancel(){
        on = false;
    }

}
