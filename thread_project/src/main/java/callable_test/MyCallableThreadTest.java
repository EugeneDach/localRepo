package callable_test;

import thread_numbers_generation.MyRunnableThread;

import java.util.concurrent.*;

public class MyCallableThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(new MyCallableThread());
        for(int i=0; i < 20; i++){
            executorService.execute(new MyRunnableThread());
        }
        System.out.println(future.get());
        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(new MyRunnableThread(), 5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
