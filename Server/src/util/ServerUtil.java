package util;

import java.nio.ByteBuffer;

public class ServerUtil {
    private static ServerUtil INSTANCE = null;

    private ServerUtil() {
    }

    public String ByteToString(ByteBuffer byteBuffer) {
        byte[] bytes = new byte[byteBuffer.position()];
        byteBuffer.flip();
        byteBuffer.get(bytes);
        return new String(bytes);
    }

    public static ServerUtil getInstance() {
        if (INSTANCE == null) INSTANCE = new ServerUtil();
        return INSTANCE;
    }
}
