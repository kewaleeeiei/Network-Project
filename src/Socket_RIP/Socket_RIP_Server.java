package Socket_RIP;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

public class Socket_RIP_Server {
    public void  Socket_RIP_Server(){}
    public void Response(ConfigRouter configRouter){
        try {
            System.out.println(configRouter);
            String reply = "";
            DatagramSocket socket = null;
            socket = new DatagramSocket(configRouter.getPort());
            byte[] incomingData = new byte[1024];
            while (true){
                DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
                socket.receive(incomingPacket);
                byte[] data = incomingPacket.getData();
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream is = new ObjectInputStream(in);
                try {

                    System.out.println(0);
                    List<SocketData> listOfMessages = (List<SocketData>) is.readObject();

                    System.out.println(listOfMessages);
                    for(int i=0;i<listOfMessages.size();i++){
                        System.out.println(listOfMessages.get(i).getRouterName());
                        System.out.println(listOfMessages.get(i).getRouterPort());
                        System.out.println(listOfMessages.get(i).getRoutingTableModels());

                        for(int j=0;j<listOfMessages.get(i).getRoutingTableModels().size();j++){
                            System.out.println("**********");
                            System.out.println(listOfMessages.get(i).getRoutingTableModels().get(j).getDest_sub());
                            System.out.println(listOfMessages.get(i).getRoutingTableModels().get(j).getNext_router());
                            System.out.println(listOfMessages.get(i).getRoutingTableModels().get(j).getHops_to_dest());
                        }
                        System.out.println(" ");
                    }
                    System.out.println(2);
                    reply="ok";

                } catch (Exception e) {
                    System.out.println("error");
                    System.out.println(e);
                    reply="error";
                }

                // responst to clients
                InetAddress IPAddress = incomingPacket.getAddress();
                int port = incomingPacket.getPort();
                byte[] replyBytea = reply.getBytes();
                DatagramPacket replyPacket = new DatagramPacket(replyBytea, replyBytea.length, IPAddress, port);
                socket.send(replyPacket);
            }
        }
        catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
        }
    }
}
