package client.data.datasource;

import client.data.RepositoryImpl;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//TODO Server와 연결되는 코드를 작성해야하는 클래스
// Port 5050, ip : 추후 지정
public class ServerConnection {
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket socket;

    public ServerConnection() {
        try {
            socket = new Socket("127.0.0.1", 5050);//LocalHost로 port 5050연결
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)), true); // Buffer에 사용할 수 있는 writer 클래스 생성 후 socket에 연결된 outputStream에 연결하는 과정
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public synchronized void send(String text) {
        writer.println(text);//전송
    }

    public void read(DataReceiveCallback callback) {
        new Thread(() -> {
            try {
                String data = reader.readLine();
                System.out.println("받은 데이터 : " + data);
                callback.accept(data);
            } catch (IOException e) {
                e.printStackTrace();
                callback.fail(e.getMessage());
            }
        }).start();
    }

    public void login(RepositoryImpl.ServerConnectionCallback callback) {
        new Thread(() -> {
            try {
                String data = reader.readLine();
                System.out.println("받은 데이터 : " + data);
                //TODO 받은 데이터 정리
                callback.accept();
            } catch (IOException e) {
                e.printStackTrace();
                callback.error(e.getMessage());
            }
        }).start();
    }

    public interface DataReceiveCallback {
        void accept(String data);

        void fail(String data);
    }

}
