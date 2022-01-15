package effective_java.item88;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.InvalidPropertiesFormatException;

// 방어적 복사를 사용하는 불변 클래스
public class SerializablePeriod implements Serializable {
    private Date start;
    private Date end;

    public SerializablePeriod(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return "SerializablePeriod{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    // 유효성 검사를 하는 readObject
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        // 가변 요소들을 방어적으로 복사한다. -> final을 제거해야 한다.
        start = new Date(start.getTime());
        end = new Date(start.getTime());

        // 불변식을 만족하는지 검사한다.
        if (start.compareTo(end) > 0) {
            throw new InvalidPropertiesFormatException(start + " after" + end);
        }
    }
}
