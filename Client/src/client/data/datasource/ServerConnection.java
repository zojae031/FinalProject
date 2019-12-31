package client.data.datasource;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//TODO Server와 연결되는 코드를 작성해야하는 클래스
// Port 5050, ip : 추후 지정
public class ServerConnection extends Thread {
    private BufferedReader reader;
    private PrintWriter writer;
    private Scanner scanner = new Scanner(System.in);
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

    @Override
    public void run() {
        super.run();
        read();
    }

    public void send() {
        String text = scanner.nextLine();// 사용자 입력
        writer = new PrintWriter(writer, true);
        writer.println(text);//전송
    }

    public void read() {
        System.out.println("데이터 수신 준비!");
        while (!this.isInterrupted()) {
            try {
                //TODO 서버에서 오는 데이터 set을 모두 여기서 관리
                // callback을 통해 Repository Layer 까지 내려주어야 함
                System.out.println("받은 메시지 : " + reader.readLine());
            } catch (IOException e) {

            }
        }
    }
}
