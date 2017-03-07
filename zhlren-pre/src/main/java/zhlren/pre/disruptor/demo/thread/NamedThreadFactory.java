package zhlren.pre.disruptor.demo.thread;

import java.util.concurrent.ThreadFactory;

/**
 * Created by bjrenzhili on 17/3/7.
 */
public class NamedThreadFactory implements ThreadFactory {

    private String executorName;

    public NamedThreadFactory(String executorName) {
        this.executorName = executorName;
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(executorName + " Thread - " + thread.getId());
        return thread;
    }

}