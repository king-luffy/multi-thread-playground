package multithread.t6.resort;

/**
 * Created by king_luffy on 2018/5/29.
 */
public class ModiThread extends Thread {
    ReaderThread readerThread;
    public ModiThread(ReaderThread readerThread){
        this.readerThread = readerThread;
    }

    public void run(){
        readerThread.setNumber(999);
        readerThread.setReady(true);

    }
}
