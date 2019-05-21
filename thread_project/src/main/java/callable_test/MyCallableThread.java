package callable_test;

import java.util.concurrent.Callable;

public class MyCallableThread implements Callable<String> {

    public String call() throws Exception {
        return "hello from callable thread";
    }

}
