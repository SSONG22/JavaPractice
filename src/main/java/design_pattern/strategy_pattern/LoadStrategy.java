package design_pattern.strategy_pattern;

public class LoadStrategy implements MovableStrategy {
    @Override
    public void move() {
        System.out.println("도로로 이동");
    }
}
