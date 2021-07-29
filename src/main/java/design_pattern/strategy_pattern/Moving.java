package design_pattern.strategy_pattern;

public class Moving {
    private MovableStrategy movableStrategy;
    public void move(){
        movableStrategy.move();
    }
    public void setMovableStrategy(MovableStrategy movableStrategy){
        this.movableStrategy = movableStrategy;
    }
}
