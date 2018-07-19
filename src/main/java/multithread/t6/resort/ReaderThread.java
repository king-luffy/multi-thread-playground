package multithread.t6.resort;

/**
 * Created by king_luffy on 2018/5/29.
 */
public class ReaderThread extends Thread{
    private boolean ready;
    private int number;

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void run(){
        while(!ready)
            Thread.yield();
        System.out.println(number);
    }
}
