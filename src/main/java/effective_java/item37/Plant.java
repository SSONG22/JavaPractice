package effective_java.item37;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// ordinal 인덱싱 대신 EnumMap
public class Plant {
    public enum LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL
    }

    private final String name;
    private final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    // dont do this
    public static void usingOrdinalArray(List<Plant> garden) {
        // 배열과 제네릭 -> 비검사 형변환을 해야한다.
        Set<Plant>[] plantsByLifeCycleArr = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        // Arrays.fill(plantsByLifeCycleArr, new HashSet<>()); 로 리팩토링
        for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
            plantsByLifeCycleArr[i] = new HashSet<>();
        }
        for (Plant p : garden) {
            plantsByLifeCycleArr[p.lifeCycle.ordinal()].add(p);
        }

        // Print the results
        // 정확한 인덱스의 의미를 모르기 때문에 직접 레이블을 달고 있다.
        for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycleArr[i]); // 정수는 타입안전하지 않기 때문에 정확한 정숫값을 사용한다는 것을 직접 보증해야 한다.
        }
    }

    public static void usingEnumMap(List<Plant> garden) {
        // 열거타입을 키로 <- Set<Planet>[] plantsByLifeCycle은 열거 타입 상수를 값(배열인덱스)으로 매핑하기 위한 배열이다.
        Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }
        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }
        // 짧고, 안전하다
        System.out.println(plantsByLifeCycle); // 레이블링 할 필요가 없다.

        // 스트림 사용 1
        System.out.println(garden.stream()
                .collect(groupingBy(p -> p.lifeCycle)));

        // 스트림 사용 2
        System.out.println(garden.stream()
                .collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(LifeCycle.class), toSet())));
    }

    public static void main(String[] args) {
        List<Plant> plants = List.of(new Plant("plant1", LifeCycle.ANNUAL), new Plant("plant2", LifeCycle.BIENNIAL));
        usingEnumMap(plants);
    }

    @Override
    public String toString() {
        return name;
    }
}
