package src;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        ObjectOutputStream out = null;
        Scanner input = new Scanner(System.in);

        try (Socket s = new Socket("localhost", 6969)) {
            out = new ObjectOutputStream(s.getOutputStream());
            String text;
            Message message;
            while (!"exit".equalsIgnoreCase((text = input.nextLine()))) {
                message = new Message(text);
                out.writeObject(message);
                out.flush();
            }

            message = new Message(text);
            out.writeObject(message);
            out.flush();

        } catch (IOException e) {
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
