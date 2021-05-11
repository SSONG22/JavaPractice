package supplier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AnimalFactory {
    private static final Map<AnimalType, Supplier<? extends Animal>> map = new HashMap<>(); // key: enum, value: supplier

    static {
        map.put(AnimalType.CAT, Cat::new);
        map.put(AnimalType.DOG, Dog::new);
    }

    private AnimalFactory() throws Exception { // 생성자 private
        throw new Exception("Do not make an instance for this Factory");
    }

    public static Animal getAnimal(AnimalType animalType) {
        Supplier<? extends Animal> animal = map.get(animalType);
        return animal.get();
    }

    public enum AnimalType {
        CAT, DOG
    }
}
