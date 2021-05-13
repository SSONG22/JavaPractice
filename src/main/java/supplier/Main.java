package supplier;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Cat cat = (Cat) AnimalFactory.getAnimal(AnimalFactory.AnimalType.CAT);
        Dog dog = (Dog) AnimalFactory.getAnimal(AnimalFactory.AnimalType.DOG);

        cat.walk();
        dog.walk();

        Supplier<String> helloSupplier = () -> "HELLO";
        System.out.println(helloSupplier.get()+" SUPPLIER");
    }
}
