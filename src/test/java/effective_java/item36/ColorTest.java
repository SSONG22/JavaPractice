package effective_java.item36;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void 생성(){
        EnumSet<Color> sets = EnumSet.allOf(Color.class);
        sets.forEach(System.out::println);
        System.out.println("------------------");
        sets = EnumSet.noneOf(Color.class);
        sets.forEach(System.out::println);
    }

    @Test
    void EnumSet_of(){
        EnumSet<Color> sets = EnumSet.of(Color.BLUE, Color.WHITE);
        sets.forEach(System.out::println);
    }

    @Test
    void range(){
        EnumSet<Color> sets = EnumSet.range(Color.YELLOW, Color.BLUE);
        sets.forEach(System.out::println);
    }

    @Test
    void complementOf(){
        EnumSet<Color> sets = EnumSet.complementOf(EnumSet.of(Color.BLACK, Color.WHITE));
        sets.forEach(System.out::println);
    }

    @Test
    void copy(){
        List<Color> colorsList = new ArrayList<>();
        colorsList.add(Color.RED);
        EnumSet<Color> listCopy = EnumSet.copyOf(colorsList);
        listCopy.forEach(System.out::println);
    }
}