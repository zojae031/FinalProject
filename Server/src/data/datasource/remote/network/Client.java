package data.datasource.remote.network;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client extends Thread {
    private Socket client;
    private BufferedReader reader;
    private PrintWriter writer;

    private ReceiveCallback callback;

    public Client(Socket client, ReceiveCallback callback) throws IOException {
        this.client = client;
        reader = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8)),
                true);
        this.callback = callback;
    }

    @Override
    public void run() { //계속하여 입력대기
        super.run();
        while (!this.isInterrupted()) {
            try {
                callback.accept(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            reader.close();
            writer.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void send(String data) {
        writer.println(data);
    }

    interface ReceiveCallback {
        void accept(String data);
    }
}
