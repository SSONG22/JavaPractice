package effective_java.item88;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

// 가변 공격의 예
public class MutablePeriod {

    // period 인스턴스
    public final SerializablePeriod period;

    // 시작,종료 시각 필드 - 외부에서 접근할 수 없어야 한다.
    public final Date start;
    public final Date end;

    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            // 유효한 인스턴스를 직렬화한다.
            out.writeObject(new SerializablePeriod(new Date(), new Date()));

            /**
             * 악의적인 '이전 객체 참조', 즉 내부 Date 필드로의 참조를 추가한다.
             * */
            byte[] ref = {0x71, 0, 0x7e, 0, 5}; // Ref #5
            bos.write(ref); // The start field
            ref[4] = 4; // Ref # 4
            bos.write(ref); // The end field

            // 역직렬화 후 Date 참조를 '훔친다'
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            period = (SerializablePeriod) in.readObject();
            start = (Date) in.readObject();
            end = (Date) in.readObject();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    // 의도적으로 내부의 값을
    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        SerializablePeriod p = mp.period;
        Date pEnd = mp.end;

        // 시간을 되돌리자.
        pEnd.setYear(78);
        System.out.println(p);

        pEnd.setYear(69);
        System.out.println(p);
    }
}
