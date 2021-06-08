package whiteship.generic2;

public class Banana implements Entity<Integer> {
    private Integer id;
    @Override
    public Integer getId() {
        return id;
    }
    public static Banana of(Integer id) {
        Banana banana = new Banana();
        banana.id = id;
        return banana;
    }
}
