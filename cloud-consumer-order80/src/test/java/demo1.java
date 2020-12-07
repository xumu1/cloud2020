import org.junit.Test;

import java.util.concurrent.*;

/**
 * Description:
 * date: 2020-12-7
 *
 * @author xumu
 */
public class demo1 {
    @Test
    public void test1() throws InterruptedException, ExecutionException, TimeoutException {
        long l1 = System.currentTimeMillis();
        ExecutorService es = Executors.newCachedThreadPool();
        String  s = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(500);
                return "hello";
            }
        }).get(1, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis()-l1 +" ..");
        System.out.println(s);
    }
}
