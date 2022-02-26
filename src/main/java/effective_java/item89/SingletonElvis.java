package effective_java.item89;

import java.io.Serializable;
import java.util.Arrays;

public class SingletonElvis implements Serializable {
    public static final SingletonElvis INSTANCE = new SingletonElvis();

    private SingletonElvis() {

    }

    // transient 가 아닌 참조 필드를 가지고 있다.
    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    // 인스턴스 통제를 위한 readResolve
    private Object readResolve() {
        // 진짜 Elvis를 반환하고, 가짜 Elvis는 GC에 맡긴다.
        return INSTANCE;
    }
}
