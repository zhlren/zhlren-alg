package zhlren.pre.disruptor.demo.handler;

import com.lmax.disruptor.ExceptionHandler;

/**
 * Created by bjrenzhili on 17/3/8.
 */
public class MExceptionHandler implements ExceptionHandler{

    public void handleEventException(Throwable ex, long sequence, Object event) {

    }

    public void handleOnStartException(Throwable ex) {

    }

    public void handleOnShutdownException(Throwable ex) {

    }

}
