package zhlren.pre.disruptor.demo.handler;

import com.lmax.disruptor.WorkHandler;
import zhlren.pre.disruptor.demo.event.MEvent;

/**
 * Created by bjrenzhili on 17/3/7.
 */
public class MWorkerHandler implements WorkHandler<MEvent> {

    private String workerName;

    public MWorkerHandler(String workerHandlerName){
        this.workerName = workerHandlerName;
    }

    public void onEvent(MEvent event) throws Exception {
        System.out.println(System.currentTimeMillis()+"---"+workerName+"---"+event.getT());
    }

}
