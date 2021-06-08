package whiteship.generic2;

public class Apple extends Entity<Integer>{

    public static Apple of(Integer id){
        Apple apple = new Apple();
        apple.id = id;
        return apple;
    }
}
