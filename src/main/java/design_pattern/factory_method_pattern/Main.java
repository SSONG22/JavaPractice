package design_pattern.factory_method_pattern;

public class Main {
    public static void main(String[] args) {

        Shop one = new MarketOne();
        Shopping vitamin = one.shopping("HEALTH");
        Shopping chicken = one.shopping("FOOD");

        Shop two = new MarketTwo();
        Shopping protein = two.shopping("HEALTH");
        Shopping egg = two.shopping("FOOD");
    }
}
