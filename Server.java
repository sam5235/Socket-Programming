import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(7000); // started listening on port 7000
            Socket s = ss.accept();// establishes connection
            // prepare input stream to receive message from client
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String serverName = "Server of Samiya and Yordanos";
            String serverNumber = ((int) (Math.random() * 100) + 1) + "";
            String clientName = (String) dis.readUTF();
            String clientNumber = (String) dis.readUTF();
            int cln = Integer.parseInt(clientNumber);
            if (cln < 1 || cln > 100) {
                System.out.println("Dear Client, Your input number is out of range, 1 to 100, Thank you for connecting");
                ss.close();

            }else{

                System.out.println("Client Name = " + clientName);
                System.out.println("Server Name = " + serverName);
                System.out.println("Client Number = " + cln);
                System.out.println("Server Number = " + serverNumber);
                System.out.println("Sum of client number and server number = " + (Integer.parseInt(serverNumber) + cln));
                
                // preparing output stream to send message to client
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF(serverNumber);
                dout.flush();
                dout.writeUTF(serverName);
                dout.flush();
                ss.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}