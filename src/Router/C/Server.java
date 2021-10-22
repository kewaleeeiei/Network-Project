package Router.C;

import Socket_RIP.ConfigRouter;
import Socket_RIP.Socket_RIP_Server;

public class Server {
    public static void main(String[] args) {

            ConfigRouter configRouter =new ConfigRouter();
            configRouter.setRouterFile("Router_C.txt");
            configRouter.setRouterName("Router_C");
            configRouter.setPort(9093);

            Socket_RIP_Server socketServer=new Socket_RIP_Server();
            socketServer.Response(configRouter);

    }
}
