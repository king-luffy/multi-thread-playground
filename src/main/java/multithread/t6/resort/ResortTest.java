package multithread.t6.resort;

/**
 * Created by king_luffy on 2018/5/29.
 */
public class ResortTest {
    public static void main(String[] args) {
        for(int i = 0;i<100000;i++) {
            ReaderThread readerThread = new ReaderThread();
            ModiThread modiThread = new ModiThread(readerThread);
            readerThread.start();
            modiThread.start();
        }
    }
}
