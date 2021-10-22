package Socket_RIP;

import java.net.InetAddress;

public class ConfigRouter {
    public void ConfigRouter(){

    }
    static int routerPort;
    static String routerIP;
    static String routerName;
    static String routerFile;
    static String folder="Data/";

    public int getPort(){
        return routerPort;
    }
    public void setPort(int routerPort) {
        this.routerPort = routerPort;
    }

    public String getIp(){
        try {
            InetAddress address= InetAddress.getLocalHost();
            String ipAddress =  address.getHostAddress();
            return ipAddress;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public void setIP(String routerIP) {
        this.routerIP = routerIP;
    }

    public String getRouterName(){
        return routerName;
    }
    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public String getFile(){
        return routerFile;
    }
    public void setRouterFile(String routerFile) {
        this.routerFile = routerFile;
    }

    public String getFolder(){
        return folder;
    }

}