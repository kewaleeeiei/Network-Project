package service;

import model.RouterModel;
import model.RoutingTableModel;

import javax.xml.ws.ServiceMode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

@ServiceMode
public class RoutingTable {

    public List<RoutingTableModel> createdRoutingTable(List<RoutingTableModel> router, String filename){
//        RoutingTableModel routingTableModel = new RoutingTableModel();
        try {
            File myObj = new File ("C:/Users/Baifern/Desktop/baifern/year1_sem1/network/ProjectJaVa/test3/Network-Project/Data/" + filename);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                RoutingTableModel routingTableModel = new RoutingTableModel(data.split(":")[0], data.split(":")[1], data.split(":")[2]);
                router.add(routingTableModel);

            }
//
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return router;

    }

    public void printRoutingTable(List<RoutingTableModel> router, String routerName){
        System.out.printf("|                    %-41s|\n", "Routing Table in " + routerName);
        System.out.println("|   destination subnet   |   next router   |   hops to dest   |");
        for (int i = 0; i < router.size() ; i++){
            System.out.printf("|       %-17s|       %-10s|         %-9s|\n", router.get(i).getDest_sub(), router.get(i).getNext_router(), router.get(i).getHops_to_dest());
        }

    }

    public void printRouterList(List<RouterModel> routerList){

        for (int i = 0; i < routerList.size() ; i++){
            System.out.printf("|            %-49s|\n", "Routing Table in " + routerList.get(i).getName() + " (Port : " + routerList.get(i).getPort() +")");
            System.out.println("|   destination subnet   |   next router   |   hops to dest   |");

            for (int j = 0; j < routerList.get(i).getRoutingTableModels().size() ; j++){

                System.out.printf("|       %-17s|       %-10s|         %-9s|\n", routerList.get(i).getRoutingTableModels().get(j).getDest_sub(), routerList.get(i).getRoutingTableModels().get(j).getNext_router(), routerList.get(i).getRoutingTableModels().get(j).getHops_to_dest());
            }
            System.out.println();
//             print neighbor
//            for (int k = 0; k < routerList.get(i).getNeighbors().size() ; k++){
//
//                System.out.printf("|       %-17s|\n", routerList.get(i).getNeighbors().get(k).getName());
//                System.out.printf("|       %-17s|\n", routerList.get(i).getNeighbors().get(k).getRoutingTableModel());
//
//            }
//            System.out.println();
        }

    }

    public List<RouterModel> deleteRouter(List<RouterModel> routerList, List<RoutingTableModel> router, String filename){
//        routerList.createdRoutingTable
        return  routerList;
    }

}
