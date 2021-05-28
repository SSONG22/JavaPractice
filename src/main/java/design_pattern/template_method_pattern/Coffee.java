package design_pattern.template_method_pattern;

public abstract class Coffee {
    final void makeCoffee() {
        boilWater();
        putEspresso();
        putIce();
        putExtra();
    }

    //SubClass에게 확장/변화가 필요한 코드만 코딩
    abstract void putExtra();

    // 공통된 부분은 상위 클래스에서 해결해 코드 중복을 최소화 시킨다.
    private void boilWater() {
        System.out.println("물을 끓인다.");
    }

    private void putEspresso() {
        System.out.println("끓는 물에 에스프레소를 넣는다.");
    }

    private void putIce() {
        System.out.println("얼음을 넣는다.");
    }
}
