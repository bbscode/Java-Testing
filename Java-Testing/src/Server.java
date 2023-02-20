package src;

import java.net.*;
import java.util.Scanner;
import java.io.*;
import src.*;

public class Server {

    public static ObjectInputStream in;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6969);
        ss.setReuseAddress(true);

        Socket s = ss.accept();
        System.out.println("client connected");
        in = new ObjectInputStream(s.getInputStream());
        Message mes = new Message(null);
        try {
            mes = (Message) in.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            System.exit(1);
        }
        System.out.println(mes.getText());

        in.close();
        ss.close();
        s.close();
    }

    private class ClientHandler implements Runnable {

        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            Message mes = new Message(null);
            String line;
            try {
                in = new ObjectInputStream(clientSocket.getInputStream());
                mes = (Message) in.readObject();
                while (mes.getText() != null) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
