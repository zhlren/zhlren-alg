package zhlren.pre.disruptor.demo;

import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.junit.Test;
import zhlren.pre.disruptor.demo.event.MEvent;
import zhlren.pre.disruptor.demo.event.MEventFactory;
import zhlren.pre.disruptor.demo.handler.MEventProducer;
import zhlren.pre.disruptor.demo.handler.MWorkerHandler;
import zhlren.pre.disruptor.demo.thread.NamedThreadFactory;
import zhlren.pre.disruptor.demo.thread.TThread;

import java.io.IOException;

/**
 * Created by bjrenzhili on 17/3/7.
 */
public class DisruptorTest {

    public static final int CONSUMER_NUMBER = 4;

    @Test
    public void test() throws IOException, InterruptedException {

        // 指定 ring buffer字节大小, must be power of 2.
        int bufferSize = 1024;

        NamedThreadFactory threadFactory = new NamedThreadFactory("drTest");

        // The factory for the event
        MEventFactory factory = new MEventFactory();

        // Construct the Disruptor
        Disruptor<MEvent> disruptor = new Disruptor<MEvent>(factory, bufferSize, threadFactory, ProducerType.SINGLE,
                new YieldingWaitStrategy());

        MWorkerHandler[] mWorkerHandlers = new MWorkerHandler[CONSUMER_NUMBER];

        for (int i = 0; i < CONSUMER_NUMBER; i++) {
            mWorkerHandlers[i] = new MWorkerHandler("drTestWorker" + i);
        }

        disruptor.handleEventsWithWorkerPool(mWorkerHandlers);

        // Start the Disruptor, starts all threads running
        disruptor.start();

        for (int i = 0; i < 1; i++) {
            MEventProducer mEventProducer = new MEventProducer(disruptor.getRingBuffer());
            TThread tThread = new TThread(mEventProducer);
            tThread.start();
        }

        System.in.read();

    }

}
