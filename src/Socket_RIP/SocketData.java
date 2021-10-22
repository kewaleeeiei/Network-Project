package Socket_RIP;

import model.RoutingTableModel;

import java.io.Serializable;
import java.util.List;

public class SocketData implements Serializable  {


    public SocketData(int routerPort, String routerName, List<RoutingTableModel> routingTableModels){
        this.routerPort = routerPort;
        this.routerName = routerName;
        this.routingTableModels=routingTableModels;
    }
    private int routerPort;
    private String routerName;
    private List<RoutingTableModel> routingTableModels;

    public int getRouterPort() {
        return routerPort;
    }
    public void setRouterPort(int routerPort) {
        this.routerPort = routerPort;
    }

    public String getRouterName() {
        return routerName;
    }
    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public String toString() {
        return  getRouterPort() + " " + getRouterName();
    }

    public List<RoutingTableModel> getRoutingTableModels() {
        return routingTableModels;
    }
}
