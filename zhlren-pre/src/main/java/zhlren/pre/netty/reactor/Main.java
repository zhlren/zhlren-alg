package zhlren.pre.netty.reactor;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by bjrenzhili on 17/3/13.
 */
public class Main {

    @Test
    public void testReactor() throws IOException {
        Reactor reactor = new Reactor();
        new Handler(reactor.selector);
        reactor.run();
    }

}
