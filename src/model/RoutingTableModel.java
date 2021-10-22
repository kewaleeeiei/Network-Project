package model;

import java.io.Serializable;

public class RoutingTableModel  implements Serializable {

    private String dest_sub;

    private String next_router;

    private String  hops_to_dest;


    public String getDest_sub() {
        return dest_sub;
    }

    public void setDest_sub(String dest_sub) {
        this.dest_sub = dest_sub;
    }

    public String getNext_router() {
        return next_router;
    }

    public void setNext_router(String next_router) {
        this.next_router = next_router;
    }

    public String getHops_to_dest() {
        return hops_to_dest;
    }

    public void setHops_to_dest(String hops_to_dest) {
        this.hops_to_dest = hops_to_dest;
    }

    public RoutingTableModel(String dest_sub, String next_router, String hops_to_dest) {
        this.dest_sub = dest_sub;
        this.next_router = next_router;
        this.hops_to_dest = hops_to_dest;
    }

    public RoutingTableModel() {

    }

    @Override
    public String toString() {
        return "[destination subnet = " + dest_sub + ", next router = " + next_router + ", hops to dest = " + hops_to_dest +" ]";
    }
}
