package design_pattern.strategy_pattern;

public class RailLoadStrategy implements MovableStrategy {
    @Override
    public void move() {
        System.out.println("선로 이동");
    }
}
