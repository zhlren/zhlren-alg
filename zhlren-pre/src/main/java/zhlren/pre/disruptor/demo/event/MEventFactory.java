package zhlren.pre.disruptor.demo.event;

import com.lmax.disruptor.EventFactory;

/**
 * Created by bjrenzhili on 17/3/7.
 */
public class MEventFactory implements EventFactory<MEvent>{

    public MEvent newInstance() {
        return new MEvent();
    }

}
