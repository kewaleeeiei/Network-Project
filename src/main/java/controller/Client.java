package controller;


import java.io.*;
import java.net.*;

import static java.lang.Integer.parseInt;

public class Client {

    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;

    @Deprecated
    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost",6666);
    }



    public Client(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input  = new DataInputStream(System.in);

            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {            System.out.println("DisConnected");

            System.out.println(u);
        }
        catch(IOException i)
        {System.out.println("DisConnected2");
            System.out.println(i);
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}