package zhlren.pre.disruptor.demo.event;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * Created by bjrenzhili on 17/3/7.
 */
public class EventSample extends Event{

    private int t;

    public EventSample(@NamedArg("eventType") EventType<? extends Event> eventType) {
        super(eventType);
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

}
