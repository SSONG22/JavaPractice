package whiteship.generic2;

public class Banana extends Entity<Integer> {
    public static Banana of(Integer id) {
        Banana banana = new Banana();
        banana.id = id;
        return banana;
    }
}
