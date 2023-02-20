package src;

import java.net.*;
import java.util.Scanner;
import java.io.*;
import src.*;
import java.lang.*;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        ObjectInputStream in = null;
        try {
            server = new ServerSocket(6969);
            server.setReuseAddress(true);

            while (true) {
                Socket socket = server.accept();
                System.out.println("client connected");
                ClientHandler clientSocket = new ClientHandler(socket);
                new Thread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private static class ClientHandler implements Runnable {

        private final Socket clientSocket;
        private ObjectInputStream in;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {

            Message line;
            try {
                in = new ObjectInputStream(clientSocket.getInputStream());
                while (true) {
                    try {
                        line = (Message) in.readObject();
                        System.out.println(line.getText());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
