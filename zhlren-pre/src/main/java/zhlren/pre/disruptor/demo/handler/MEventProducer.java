package zhlren.pre.disruptor.demo.handler;

import com.lmax.disruptor.RingBuffer;
import zhlren.pre.disruptor.demo.event.MEvent;

/**
 * Created by bjrenzhili on 17/3/8.
 */
public class MEventProducer {

    private final RingBuffer<MEvent> ringBuffer;

    public MEventProducer(RingBuffer<MEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * onData用来发布事件，每调用一次就发布一次事件事件
     * 它的参数会通过事件传递给消费者
     *
     */
    public void onData(int bb) {
        //可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
        long sequence = ringBuffer.next();
        try {
            //用上面的索引取出一个空的事件用于填充
            MEvent event = ringBuffer.get(sequence);// for the sequence
            event.setT(bb);
        }
        finally {
            //发布事件
            ringBuffer.publish(sequence);
        }
    }

}
