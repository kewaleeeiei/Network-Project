package Router.A;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.*;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import jdk.nashorn.internal.parser.JSONParser;
import model.RoutingTableModel;

import controller.*;
import org.json.JSONArray;
import org.json.JSONObject;
import service.RouterService;
import service.RoutingTable;
import model.*;

import java.io.Serializable;

public class Client {
    DatagramSocket Socket;

    public Client() {

    }
    public static List<RoutingTableModel> dataRouting = new ArrayList<RoutingTableModel>();

    public void createAndListenSocket() {
        try {

/*            FileReader fileReader =new FileReader();
            fileReader.createdRoutingTable(dataRouting );
            System.out.println("dataRouting");
            System.out.println(dataRouting);  //  ArrayList*/

            RoutingTable routingTable = new RoutingTable();
            RouterService routerService = new RouterService();
            List<RoutingTableModel> router_A = new ArrayList<RoutingTableModel>();
            routingTable.createdRoutingTable(router_A, "Router_A.txt");
            List<RouterModel> routerList = new ArrayList<RouterModel>();
            RouterModel routerModelA = new RouterModel(router_A,"Router A", "9091");
            List<Neighbor> neighbors_A = new ArrayList<Neighbor>();
            // neighbors_A.add(new Neighbor(routerModelB.getName(), routerModelB.getPort(),routerModelB.getRoutingTableModels()));
            //neighbors_A.add(new Neighbor(routerModelC.getName(), routerModelC.getPort(), routerModelC.getRoutingTableModels()));
            // neighbors_A.add(new Neighbor(routerModelF.getName(), routerModelF.getPort(), routerModelF.getRoutingTableModels()));

            System.out.println(routerModelA.getRoutingTableModels());
            routerService.addNeighbor(routerModelA, neighbors_A);
            routerList.add(routerModelA);
            routingTable.printRouterList((routerList));

            Object object = routerModelA.getRoutingTableModels();
            System.out.println(object.getClass().getName());

            Socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] incomingData = new byte[1024];
/*            Student student = new Student(1, "Bijoy", "Kerala");
            System.out.println("student");
            System.out.println(student);*/

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            //outputStream.write(routerModelA.getRoutingTableModels());
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            //  os.writeObject(student);
            System.out.println(1);
            System.out.println( routerModelA.getRoutingTableModels().toString());
            JSONArray array = new JSONArray(routerModelA.getRoutingTableModels().toString());
            System.out.println(array);

//            Gson g = new Gson(); Player p = g.fromJson(jsonString, Player.class)
//
//            Read more: https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz79r4dzvRg

            os.writeObject(array.toString());
            // os.writeObject(object);
            System.out.println(2);



            byte[] data = outputStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 9876);
            Socket.send(sendPacket);
            System.out.println("Message sent from client");
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            Socket.receive(incomingPacket);
            String response = new String(incomingPacket.getData());
            System.out.println("Response from server:" + response);
            Thread.sleep(2000);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.createAndListenSocket();
    }
}