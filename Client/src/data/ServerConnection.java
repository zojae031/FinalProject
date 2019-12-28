package data;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//TODO Server와 연결되는 코드를 작성해야하는 클래스
// Port 5050, ip : 추후 지정
// 서버가 넌 블러킹으로 되어있으니 순서에 상관없이 좀더 편하게 하실 수 있으실겁니다.
public class ServerConnection extends Thread {
    BufferedWriter writer;
    BufferedReader reader;
    PrintWriter out;
    Scanner scanner = new Scanner(System.in);
    Socket socket;


    public ServerConnection() {
        try {
            socket = new Socket("127.0.0.1", 5050);//LocalHost로 port 5050연결
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Buffer에 사용할 수 있는 writer 클래스 생성 후 socket에 연결된 outputStream에 연결하는 과정
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
        out = new PrintWriter(writer, true);
        out.println(text);//전송
    }

    public void read() {
        System.out.println("데이터 수신 준비!");
        while (!this.isInterrupted()) {
            try {
                System.out.println("받은 메시지 : " + reader.readLine());
            } catch (IOException e) {

            }
        }
    }
}
