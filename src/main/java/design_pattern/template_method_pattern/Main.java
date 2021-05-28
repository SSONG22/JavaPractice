package design_pattern.template_method_pattern;

public class Main {
    /* 서브 클래스로 캡슐화에 전체 일을 수행하는 구조는 바꾸지 않으면서 특정 단계에서 수행하는 내역을 바꾸는 패턴이다.
    전체적으로는 동일하면서 부분적으로 다른 구문으로 구성된 메서드의 코드 중복을 최소화할 때 유용하다.
    https://www.crocus.co.kr/1531
    * */
    public static void main(String[] args) {
        IceAmericano americano = new IceAmericano();
        IceLatte latte = new IceLatte();
        System.out.println("Americano >> ");
        americano.makeCoffee();
        System.out.println("and Latte >> ");
        latte.makeCoffee();
    }
}
