package Socket_RIP;


import model.RoutingTableModel;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class Socket_RIP_Client {
    DatagramSocket Socket;
    public void Socket_RIP_Client(){

    }

    public void Send(ConfigRouter configRouter , List<RoutingTableModel> routingTableModels) {
        try{

            // เตรียนข้อมูลที่จะส่ง
            List<SocketData> messages = new ArrayList<>();
            messages.add(new SocketData(configRouter.getPort() , configRouter.getRouterName() ,routingTableModels));
            System.out.println(messages);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(messages);

            // sending
            byte[] data = outputStream.toByteArray();
            byte[] incomingData = new byte[1024];
            Socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(configRouter.getIp());
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress,configRouter.getPort());
            Socket.send(sendPacket);

            //response
            System.out.println("Message sent from client");


            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            Socket.receive(incomingPacket);
            String response = new String(incomingPacket.getData());
            System.out.println("Response from server:" + response);
        }catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
            //e.printStackTrace();
        }
    }
}
