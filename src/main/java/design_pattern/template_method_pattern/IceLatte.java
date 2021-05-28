package design_pattern.template_method_pattern;

public class IceLatte extends Coffee {
    @Override
    void putExtra() {
        System.out.println("우유를 넣는다.");
    }
}
