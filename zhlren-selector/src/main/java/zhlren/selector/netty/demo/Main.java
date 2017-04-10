package zhlren.selector.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * Created by bjrenzhili on 17/4/10.
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(1<<2);
            String host = "127.0.0.1";
            int port = 18007;

            EventLoopGroup bossEventLoopGroup = new NioEventLoopGroup(1);
            EventLoopGroup workerEventLoopGroup = new NioEventLoopGroup();
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossEventLoopGroup, workerEventLoopGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ReadTimeoutHandler(30))
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.AUTO_READ, true).childOption(ChannelOption.SO_LINGER, 0)
                    .childOption(ChannelOption.TCP_NODELAY, true);

            ChannelFuture future = serverBootstrap.bind(host, port).sync();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
