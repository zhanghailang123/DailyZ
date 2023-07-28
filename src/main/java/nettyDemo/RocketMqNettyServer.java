package nettyDemo;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import org.apache.rocketmq.remoting.netty.NettyRemotingServer;
import org.apache.rocketmq.remoting.netty.NettyRequestProcessor;
import org.apache.rocketmq.remoting.netty.NettyServerConfig;
import org.apache.rocketmq.remoting.protocol.RemotingCommand;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * https://mp.weixin.qq.com/s/hjXzPu5-_jNGYx7NwdSpXw
 * @author hailang.zhang
 * @since 2023-07-27
 */
public class RocketMqNettyServer {

    public static void main(String[] args) throws IOException {
        NettyServerConfig serverConfig = new NettyServerConfig();
        serverConfig.setListenPort(8888);
        serverConfig.setServerSelectorThreads(2);
        serverConfig.setServerWorkerThreads(8);

        NettyRemotingServer server = new NettyRemotingServer(serverConfig);
        ExecutorService poolA = new ThreadPoolExecutor(4,4,0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024));
        ExecutorService poolB = new ThreadPoolExecutor(4,4,0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024));

        NettyRequestProcessor processorA = new NettyRequestProcessor() {
            @Override
            public RemotingCommand processRequest(ChannelHandlerContext channelHandlerContext, RemotingCommand remotingCommand) throws Exception {
                System.out.println("received from client" + remotingCommand.getCode() + "---" + remotingCommand.getRemark());
                RemotingCommand response = RemotingCommand.createResponseCommand(0, "server response");
                switch (response.getCode()) {
                    case 0:
                        response.setBody(new String("hello sync 0").getBytes());
                    case 1:
                        response.setBody(new String("hello sync 1").getBytes());
                    default:
                        break;
                }
                return response;
            }

            @Override
            public boolean rejectRequest() {
                return false;
            }
        };

        NettyRequestProcessor processorB = new NettyRequestProcessor() {
            @Override
            public RemotingCommand processRequest(ChannelHandlerContext channelHandlerContext, RemotingCommand remotingCommand) throws Exception {
                System.out.println("received from client" + remotingCommand.getCode() + "---" + remotingCommand.getRemark());
                RemotingCommand response = RemotingCommand.createResponseCommand(0, "server response");
                switch (response.getCode()) {
                    case 9:
                        response.setBody(new String("hello sync 9").getBytes());
                    default:
                        break;
                }
                return response;
            }

            @Override
            public boolean rejectRequest() {
                return false;
            }
        };

        //注册协议--对应的处理器
        server.registerProcessor(0, processorA, poolA);
        server.registerProcessor(1, processorA, poolA);
        server.registerProcessor(9, processorB, poolB);
        
        server.start();

        System.out.println("server start success : " + JSON.toJSONString(serverConfig));

        System.in.read();
    }
}