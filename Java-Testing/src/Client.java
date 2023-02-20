package src;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import src.*;

public class Client {
    public static ObjectOutputStream out;

    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("localhost", 6969)) {
            out = new ObjectOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
      
            out.writeObject(Message.sendMessage(input.nextLine()));
            out.flush();
            
            input.close();
            out.close();
            s.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
  

}
