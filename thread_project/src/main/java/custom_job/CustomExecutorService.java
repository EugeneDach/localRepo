package custom_job;

import java.util.concurrent.*;

public class CustomExecutorService extends ThreadPoolExecutor {

    private BlockingQueue<CustomFutureTask> waitJobsQueue = new LinkedBlockingQueue<CustomFutureTask>();
    private BlockingQueue<CustomFutureTask> runningJobsQueue = new LinkedBlockingQueue<CustomFutureTask>();


    public CustomExecutorService(int nThreads) {
        /**
         * копипаст Executors.newFixedThreadPool(2);
         * необходимо посмотреть внутреннюю реализацию конструктора
         * перейдите к Executors
         *
         * найдите:
         *
         *     public static ExecutorService newFixedThreadPool(int nThreads) {
         return new ThreadPoolExecutor(nThreads, nThreads,
         0L, TimeUnit.MILLISECONDS,
         new LinkedBlockingQueue<Runnable>());
         }
         */
        super(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task);
        CustomFutureTask customFutureTask = new CustomFutureTask(task, ftask);

        if (runningJobsQueue.contains(customFutureTask)) {
            waitJobsQueue.add(customFutureTask);
        } else {
            runningJobsQueue.add(customFutureTask);
            execute(ftask);
        }
        return ftask;
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
    }
}

class CustomFutureTask {
    private Callable customJob;
    private RunnableFuture runnableFuture;

    public CustomFutureTask(Callable customJob, RunnableFuture runnableFuture) {
        this.customJob = customJob;
        this.runnableFuture = runnableFuture;
    }

    public Callable getCustomJob() {
        return customJob;
    }

    public void setCustomJob(CustomJob customJob) {
        this.customJob = customJob;
    }

    public RunnableFuture getRunnableFuture() {
        return runnableFuture;
    }

    public void setRunnableFuture(RunnableFuture runnableFuture) {
        this.runnableFuture = runnableFuture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomFutureTask that = (CustomFutureTask) o;

        return customJob != null ? customJob.equals(that.customJob) : that.customJob == null;
    }

    @Override
    public int hashCode() {
        return customJob != null ? customJob.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CustomFutureTask{" +
                "customJob=" + customJob +
                ", runnableFuture=" + runnableFuture +
                '}';
    }
}
