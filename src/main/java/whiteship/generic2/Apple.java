package whiteship.generic2;

public class Apple implements Entity<Integer>{
    private Integer id;
    public static Apple of(Integer id){
        Apple apple = new Apple();
        apple.id = id;
        return apple;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
