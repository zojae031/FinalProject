package data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//TODO Server와 연결되는 코드를 작성해야하는 클래스
// Port 5050, ip : 추후 지정
// 서버가 넌 블러킹으로 되어있으니 순서에 상관없이 좀더 편하게 하실 수 있으실겁니다.
public class ServerConnection {
    BufferedWriter writer;
    PrintWriter out;
    Scanner scanner = new Scanner(System.in);

    public void connect() {
        try {
            Socket socket = new Socket("127.0.0.1", 5050);//LocalHost로 port 5050연결
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Buffer에 사용할 수 있는 writer 클래스 생성 후 socket에 연결된 outputStream에 연결하는 과정
            String text = scanner.nextLine();// 사용자 입력
            out = new PrintWriter(writer, true); // 버퍼 형태로 전송할 수 있는 클래스 생성(이 부분은 저도 잘 모르겠습니다) BufferedWriter로 전송하면 안 보내짐. @Author 조재영
            out.println(text);//전송
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
