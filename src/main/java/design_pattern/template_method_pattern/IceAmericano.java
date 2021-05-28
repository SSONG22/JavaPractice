package design_pattern.template_method_pattern;

public class IceAmericano extends Coffee {
    @Override
    void putExtra() {
        System.out.println("시럽을 넣는다.");
    }
}
