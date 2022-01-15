package effective_java.item88;

import java.io.*;
import java.util.Base64;
import java.util.Date;

public class BogusPeriod {
    // 진짜 Period 인스턴스에서는 만들어질 수 없는 바이트 스트림
    private static final byte[] serializedForm = new byte[]{(byte) 0xac,
            (byte) 0xed, 0x00, 0x05, 0x73, 0x72, 0x00, 0x06, 0x50, 0x65, 0x72,
            0x69, 0x6f, 0x64, 0x40, 0x7e, (byte) 0xf8, 0x2b, 0x4f, 0x46,
            (byte) 0xc0, (byte) 0xf4, 0x02, 0x00, 0x02, 0x4c, 0x00, 0x03, 0x65,
            0x6e, 0x64, 0x74, 0x00, 0x10, 0x4c, 0x6a, 0x61, 0x76, 0x61, 0x2f,
            0x75, 0x74, 0x69, 0x6c, 0x2f, 0x44, 0x61, 0x74, 0x65, 0x3b, 0x4c,
            0x00, 0x05, 0x73, 0x74, 0x61, 0x72, 0x74, 0x71, 0x00, 0x7e, 0x00,
            0x01, 0x78, 0x70, 0x73, 0x72, 0x00, 0x0e, 0x6a, 0x61, 0x76, 0x61,
            0x2e, 0x75, 0x74, 0x69, 0x6c, 0x2e, 0x44, 0x61, 0x74, 0x65, 0x68,
            0x6a, (byte) 0x81, 0x01, 0x4b, 0x59, 0x74, 0x19, 0x03, 0x00, 0x00,
            0x78, 0x70, 0x77, 0x08, 0x00, 0x00, 0x00, 0x66, (byte) 0xdf, 0x6e,
            0x1e, 0x00, 0x78, 0x73, 0x71, 0x00, 0x7e, 0x00, 0x03, 0x77, 0x08,
            0x00, 0x00, 0x00, (byte) 0xd5, 0x17, 0x69, 0x22, 0x00, 0x78};

    public static void main(String[] args) {
        byte[] _serializedForm = serialize(new SerializablePeriod(new Date(), new Date()));
        SerializablePeriod p = (SerializablePeriod) deserialize(serializedForm);
        System.out.println(p);
        p = (SerializablePeriod) deserialize(_serializedForm);
        System.out.println(p);
    }

    // 주어진 직렬화 형태(바이트 스트림)로부터 객체를 만들어 반환한다.
    private static Object deserialize(byte[] sf) {
        try {
            InputStream is = new ByteArrayInputStream(sf);
            ObjectInputStream ois = new ObjectInputStream(is);
            return ois.readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static byte[] serialize(Object object) {
        byte[] serializedMember = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(baos)) {
                outputStream.writeObject(object);
                serializedMember = baos.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String base64Encoded = Base64.getEncoder().encodeToString(serializedMember);

        return Base64.getDecoder().decode(base64Encoded);
    }
}
