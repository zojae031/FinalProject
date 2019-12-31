package data;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//TODO Server와 연결되는 코드를 작성해야하는 클래스
// Port 5050, ip : 추후 지정
// 서버가 넌 블러킹으로 되어있으니 순서에 상관없이 좀더 편하게 하실 수 있으실겁니다.
public class ServerConnection {
    public void ConnectServer() {
        try {
            Socket s = new Socket("192.168.123.5", 5050);
            System.out.println("## 클라이언트 실행");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            pw.println(str);
            pw.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
