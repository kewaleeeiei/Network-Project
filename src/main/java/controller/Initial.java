package controller;

import model.Neighbor;
import model.RouterModel;
import model.RoutingTableModel;
import service.RouterService;
import service.RoutingTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Initial extends Thread {
//

    public static void main(String[] args) throws InterruptedException, IOException {
        int ascii = 65;

        RoutingTable routingTable = new RoutingTable();
        RouterService routerService = new RouterService();


        List<RoutingTableModel> router_A = new ArrayList<RoutingTableModel>();
        routingTable.createdRoutingTable(router_A, "Router_A.txt");

        List<RoutingTableModel> router_B = new ArrayList<RoutingTableModel>();
        routingTable.createdRoutingTable(router_B, "Router_B.txt");

        List<RoutingTableModel> router_C = new ArrayList<RoutingTableModel>();
        routingTable.createdRoutingTable(router_C, "Router_C.txt");

        List<RoutingTableModel> router_D = new ArrayList<RoutingTableModel>();
        routingTable.createdRoutingTable(router_D, "Router_D.txt");

        List<RoutingTableModel> router_E = new ArrayList<RoutingTableModel>();
        routingTable.createdRoutingTable(router_E, "Router_E.txt");

        List<RoutingTableModel> router_F = new ArrayList<RoutingTableModel>();
        routingTable.createdRoutingTable(router_F, "Router_F.txt");



        List<RouterModel> routerList = new ArrayList<RouterModel>();
        RouterModel routerModelA = new RouterModel(router_A,"Router A", "9091");
        RouterModel routerModelB = new RouterModel(router_B,"Router B", "9092");
        RouterModel routerModelC = new RouterModel(router_C,"Router C", "9093");
        RouterModel routerModelD = new RouterModel(router_D,"Router D", "9094");
        RouterModel routerModelE = new RouterModel(router_E,"Router E", "9095");
        RouterModel routerModelF = new RouterModel(router_F,"Router F", "9096");


        List<Neighbor> neighbors_A = new ArrayList<Neighbor>();
        neighbors_A.add(new Neighbor(routerModelB.getName(), routerModelB.getPort(),routerModelB.getRoutingTableModels()));
        neighbors_A.add(new Neighbor(routerModelC.getName(), routerModelC.getPort(), routerModelC.getRoutingTableModels()));
        neighbors_A.add(new Neighbor(routerModelF.getName(), routerModelF.getPort(), routerModelF.getRoutingTableModels()));
        routerService.addNeighbor(routerModelA, neighbors_A);

        List<Neighbor> neighbors_B = new ArrayList<Neighbor>();
        neighbors_B.add(new Neighbor(routerModelA.getName(), routerModelA.getPort(),routerModelA.getRoutingTableModels()));
        neighbors_B.add(new Neighbor(routerModelE.getName(), routerModelE.getPort(), routerModelE.getRoutingTableModels()));
        neighbors_B.add(new Neighbor(routerModelF.getName(), routerModelF.getPort(), routerModelF.getRoutingTableModels()));
        routerService.addNeighbor(routerModelB, neighbors_B);

        List<Neighbor> neighbors_C = new ArrayList<Neighbor>();
        neighbors_C.add(new Neighbor(routerModelA.getName(), routerModelA.getPort(),routerModelA.getRoutingTableModels()));
        neighbors_C.add(new Neighbor(routerModelD.getName(), routerModelD.getPort(), routerModelD.getRoutingTableModels()));
        routerService.addNeighbor(routerModelC, neighbors_C);

        List<Neighbor> neighbors_D = new ArrayList<Neighbor>();
        neighbors_D.add(new Neighbor(routerModelC.getName(), routerModelC.getPort(),routerModelC.getRoutingTableModels()));
        neighbors_D.add(new Neighbor(routerModelE.getName(), routerModelE.getPort(), routerModelE.getRoutingTableModels()));
        routerService.addNeighbor(routerModelD, neighbors_D);


        List<Neighbor> neighbors_E = new ArrayList<Neighbor>();
        neighbors_E.add(new Neighbor(routerModelB.getName(), routerModelB.getPort(),routerModelB.getRoutingTableModels()));
        neighbors_E.add(new Neighbor(routerModelD.getName(), routerModelD.getPort(), routerModelD.getRoutingTableModels()));
        neighbors_E.add(new Neighbor(routerModelF.getName(), routerModelF.getPort(), routerModelF.getRoutingTableModels()));
        routerService.addNeighbor(routerModelE, neighbors_E);


        List<Neighbor> neighbors_F = new ArrayList<Neighbor>();
        neighbors_F.add(new Neighbor(routerModelA.getName(), routerModelA.getPort(),routerModelA.getRoutingTableModels()));
        neighbors_F.add(new Neighbor(routerModelB.getName(), routerModelB.getPort(), routerModelB.getRoutingTableModels()));
        neighbors_F.add(new Neighbor(routerModelE.getName(), routerModelE.getPort(), routerModelE.getRoutingTableModels()));
        routerService.addNeighbor(routerModelF, neighbors_F);
//
        routerList.add(routerModelA);
        routerList.add(routerModelB);
        routerList.add(routerModelC);
        routerList.add(routerModelD);
        routerList.add(routerModelE);
        routerList.add(routerModelF);

        routingTable.printRouterList(routerList);
        routerService.getCompletedRoutingTable(routerList);
        routingTable.printRouterList(routerList);
//        routerService.deletedRouter(routerList, "Router D");
//        routingTable.printRouterList(routerList);








//        routerService.updateRoutingTable(router_A, neighbors_A); // เพิ่มเพื่อนบ้านให้ A แล้ว A ก็อัพเดท routing table ตัวเอง
//        routerService.updateNeighborRoutingTable(routerList, routerModelA); // update routing table ของเพื่อนบ้าน A
//
//        routerService.updateRoutingTable(router_B, neighbors_B);
//        routerService.updateNeighborRoutingTable(routerList, routerModelB); // update ตารางเพื่อนบ้าน
//
//        routerService.updateRoutingTable(router_C, neighbors_C);
//        routerService.updateNeighborRoutingTable(routerList, routerModelC); // update ตารางเพื่อนบ้าน
//
//        routerService.updateRoutingTable(router_D, neighbors_D);
//        routerService.updateNeighborRoutingTable(routerList, routerModelD); // update ตารางเพื่อนบ้าน
//
//        routerService.updateRoutingTable(router_E, neighbors_E);
//        routerService.updateNeighborRoutingTable(routerList, routerModelE); // update ตารางเพื่อนบ้าน
//
//        routerService.updateRoutingTable(router_F, neighbors_F);
//        routerService.updateNeighborRoutingTable(routerList, routerModelF); // update ตารางเพื่อนบ้าน





//        Server server_A = new Server();
//        server_A.start(routerModelA.getPort());
//
//        Client client = new Client();
//        client.startConnection(routerModelA.getPort());
//        String response = client.sendMessage("hello server");
//        assertEquals("hello client", response);
//        GreetServer server =new GreetServer();

//        Server server_A = new Server();
//        server_A.openServer(routerModelA.getName(), routerModelA.getPort());
//        Thread.sleep(1000);
//        Client client_D = new Client();
//        client_D.openClient(routerModelD.getName(), routerModelD.getPort());
//        System.out.println("3333333");

    }
}
