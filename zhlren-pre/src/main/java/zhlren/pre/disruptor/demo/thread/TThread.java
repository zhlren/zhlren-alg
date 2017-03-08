package zhlren.pre.disruptor.demo.thread;

import zhlren.pre.disruptor.demo.handler.MEventProducer;

import java.util.Random;

/**
 * Created by bjrenzhili on 17/3/8.
 */
public class TThread extends Thread {

    private MEventProducer mEventProducer;

    public TThread(MEventProducer mEventProducer) {
        this.mEventProducer = mEventProducer;
    }

    public void run() {
        try {
            Random random = new Random();
            while (true) {
                int bb = random.nextInt();
                mEventProducer.onData(bb);
                Thread.sleep(100);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
