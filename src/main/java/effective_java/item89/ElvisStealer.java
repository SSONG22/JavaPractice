package effective_java.item89;

import java.io.Serializable;

public class ElvisStealer implements Serializable {

    static SingletonElvis impersonator;
    private SingletonElvis payload;

    private Object readResolve() {
        // resolve 되기 전의 Elvis 인스턴스의 참조를 저장한다.
        impersonator = payload;

        // favoriteSongs 필드에 맞는 타입의 객체를 반환한다.
        return new String[]{"A Fool Such as I"};
    }
}
