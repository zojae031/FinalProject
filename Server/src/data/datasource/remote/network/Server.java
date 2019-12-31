package data.datasource.remote.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class Server extends Thread {
    private static final int port = 5050;
    private ServerSocket socket;
    private List<Client> clients = new Vector();


    @Override
    public void run() {
        startServer();
    }

    private void startServer() {
        try {
            socket = new ServerSocket(port);

            System.out.println("IP : " + InetAddress.getLocalHost().getHostAddress());
            System.out.println("Server Open...");

            while (!this.isInterrupted()) {
                Socket clientSocket = socket.accept();
                System.out.println("클라이언트 접속 : " + clientSocket.getInetAddress());
                Client client = new Client(clientSocket, data -> System.out.println("받은 데이터 : " + data));
                client.start();
                clients.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadCast(String data) {
        for (Client c : clients) {
            c.send(data);
        }
    }

    public void close() throws IOException {
        for (Client c : clients) {
            c.close();
        }
        clients.clear();
        socket.close();
    }
}
