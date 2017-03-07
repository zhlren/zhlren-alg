package zhlren.pre.disruptor.demo.handler;

import javafx.event.Event;
import javafx.event.EventHandler;
import zhlren.pre.disruptor.demo.event.EventSample;

/**
 * Created by bjrenzhili on 17/3/7.
 */
public class ConsumerHandler<E extends Event> implements EventHandler<EventSample>{

    public void handle(EventSample event) {
    }

}
