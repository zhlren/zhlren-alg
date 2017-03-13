package zhlren.pre.netty.reactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by bjrenzhili on 17/3/13.
 */
public class Reactor implements Runnable {

    public Selector selector;

    public Reactor() {
        try {
            selector = Selector.open();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set<SelectionKey> selected = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selected.iterator();
                while (iterator.hasNext()) {
                    dispatch(iterator.next());
                }
                selected.clear();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void dispatch(SelectionKey k) {
        Runnable runnable = (Runnable) k.attachment();
        if (null != runnable) {
            runnable.run();
        }
    }

}
