package src;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import src.*;

public class Client {

    public static void main(String[] args) throws IOException {

        ObjectOutputStream out = null;
        Scanner input = new Scanner(System.in);

        try (Socket s = new Socket("localhost", 6969)) {
            out = new ObjectOutputStream(s.getOutputStream());
            String message;
            while ("exit".equalsIgnoreCase((message = input.nextLine()))) {
                out.writeObject(message);
                out.flush();
            }

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            input.close();

        }

    }

}
