package task4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutorService implements ExecutorService {

    private final ExecutorService innerExecutorService;

    MyExecutorService(int threadNumber) {
        innerExecutorService = Executors.newFixedThreadPool(threadNumber);
    }

    @Override
    public void shutdown() {
        innerExecutorService.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return innerExecutorService.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return innerExecutorService.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return innerExecutorService.isTerminated();
    }

    @Override
    public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        return innerExecutorService.awaitTermination(l, timeUnit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> callable) {
        return innerExecutorService.submit(callable);
    }

    @Override
    public <T> Future<T> submit(Runnable runnable, T t) {
        return innerExecutorService.submit(runnable, t);
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        return innerExecutorService.submit(runnable);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return innerExecutorService.invokeAll(collection);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long l, TimeUnit timeUnit) throws InterruptedException {
        return innerExecutorService.invokeAll(collection, l, timeUnit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return innerExecutorService.invokeAny(collection);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return innerExecutorService.invokeAny(collection, l, timeUnit);
    }

    @Override
    public void execute(Runnable runnable) {
        innerExecutorService.execute(runnable);
    }
}
