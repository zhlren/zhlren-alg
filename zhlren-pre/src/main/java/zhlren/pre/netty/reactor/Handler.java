package zhlren.pre.netty.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by bjrenzhili on 17/3/13.
 */
public class Handler implements Runnable {

    private SocketChannel socketChannel = null;

    private SelectionKey selectionKey;

    public Handler(Selector selector) throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.socket().bind(new InetSocketAddress("127.0.0.1",16001));
        socketChannel.configureBlocking(false);
        selectionKey = socketChannel.register(selector,0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    public void run() {
        System.out.println("--reactor test--");
    }

}
