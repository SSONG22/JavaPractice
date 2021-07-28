package design_pattern.strategy_pattern;

/* https://victorydntmd.tistory.com/292 */
public class Main {
    public static void main(String[] args) {
        Moving train = new Train();
        Moving bus = new Bus();

        train.setMovableStrategy(new RailLoadStrategy());
        bus.setMovableStrategy(new LoadStrategy());

        train.move();
        bus.move();

        bus.setMovableStrategy(new RailLoadStrategy());
        bus.move();
    }
}
