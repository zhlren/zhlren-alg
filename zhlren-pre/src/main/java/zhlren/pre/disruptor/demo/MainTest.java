package zhlren.pre.disruptor.demo;

import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import zhlren.pre.disruptor.demo.event.EventFactorySample;
import zhlren.pre.disruptor.demo.event.EventSample;
import zhlren.pre.disruptor.demo.thread.NamedThreadFactory;

/**
 * Created by bjrenzhili on 17/3/7.
 */
public class MainTest {


    public void disruptorTest(){

        // 指定 ring buffer字节大小, must be power of 2.
        int bufferSize = 1024;

        // 执行器，用于构造消费者线程
        NamedThreadFactory namedThreadFactory = new NamedThreadFactory("test");

        EventFactorySample eventFactorySample = new EventFactorySample();
        Disruptor<EventSample> disruptor = new Disruptor<EventSample>(eventFactorySample,bufferSize,namedThreadFactory,
                ProducerType.MULTI, new YieldingWaitStrategy());

        //设置事件业务处理器---消费者


        //启动disruptor线程
        disruptor.start();
    }

}
