import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 7000); // recieving or talking port 7000
            Scanner sc = new Scanner(System.in); // preparing input scanner from console
            System.out.println("Enter number between 1 and 100"); // promting the client
            String ClNumber = sc.nextLine();

            // preparing output stream to send message to server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream()); // 
            String myName = "Client of Samiya and Yordanos";
            dout.writeUTF(myName); // send client name to server
            dout.flush();
            dout.writeUTF(ClNumber); // send client number to server 
            dout.flush();
            // prepare input stream to receive message from server
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String serverNumber = (String) dis.readUTF(); // reading server number
            String serverName = (String) dis.readUTF(); // reading server name

            // showing the info to client console
            System.out.println("Client name = " + myName);
            System.out.println("Server name = " + serverName);
            System.out.println("Client number = " + ClNumber);
            System.out.println("Server number = " + serverNumber);
            System.out.println("The sum of client number and server number = " + (Integer.parseInt(serverNumber) + Integer.parseInt(ClNumber)));
            
            sc.close(); // close the scanner
            dout.close(); // close the output stream
            s.close(); // close the connection
        } catch (Exception e) {
            // handle any exception in the process
            System.out.println(e);
        }
    }
}