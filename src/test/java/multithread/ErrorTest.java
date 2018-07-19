package multithread;

import org.junit.Test;

/**
 * Created by king_luffy on 2018/5/23.
 */
public class ErrorTest {

    @Test
    public void errorTest(){
        try{
            new inn().innTest();
        }catch (Exception e){
            System.out.println();
        }
    }

    private class inn{
        public void innTest() throws Exception {
            throw new Exception("sdfds");
        }
    }
}
