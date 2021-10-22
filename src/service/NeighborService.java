package service;

import model.Neighbor;
import model.RouterModel;
import model.RoutingTableModel;

import java.util.ArrayList;
import java.util.List;

public class NeighborService {


    public List<Neighbor> addNeighborToRouter(String[] myNeighbors) {
        List<Neighbor> neighbors = new ArrayList<Neighbor>();
        RouterService routerService = new RouterService();

        for (int i = 0; i < myNeighbors.length; i++) {
            switch (myNeighbors[i]) {
                case "A":
                    neighbors.add(new Neighbor(routerService.getRouter_A().getName(), routerService.getRouter_A().getPort(), routerService.getRouter_A().getRoutingTableModels()));
                    break;
                case "B":
                    neighbors.add(new Neighbor(routerService.getRouter_B().getName(), routerService.getRouter_B().getPort(), routerService.getRouter_B().getRoutingTableModels()));
                    break;
                case "C":
                    neighbors.add(new Neighbor(routerService.getRouter_C().getName(), routerService.getRouter_C().getPort(), routerService.getRouter_C().getRoutingTableModels()));
                    break;
                case "D":
                    neighbors.add(new Neighbor(routerService.getRouter_D().getName(), routerService.getRouter_D().getPort(), routerService.getRouter_D().getRoutingTableModels()));
                    break;
                case "E":
                    neighbors.add(new Neighbor(routerService.getRouter_E().getName(), routerService.getRouter_E().getPort(), routerService.getRouter_E().getRoutingTableModels()));
                    break;
                case "F":
                    neighbors.add(new Neighbor(routerService.getRouter_F().getName(), routerService.getRouter_F().getPort(), routerService.getRouter_F().getRoutingTableModels()));
                    break;
                case "G":
                    neighbors.add(new Neighbor(routerService.getRouter_G().getName(), routerService.getRouter_G().getPort(), routerService.getRouter_G().getRoutingTableModels()));
                    break;
                case "H":
                    neighbors.add(new Neighbor(routerService.getRouter_H().getName(), routerService.getRouter_H().getPort(), routerService.getRouter_H().getRoutingTableModels()));
                    break;
                case "I":
                    neighbors.add(new Neighbor(routerService.getRouter_I().getName(), routerService.getRouter_I().getPort(), routerService.getRouter_I().getRoutingTableModels()));
                    break;
            }

        }

        return neighbors;
    }

}