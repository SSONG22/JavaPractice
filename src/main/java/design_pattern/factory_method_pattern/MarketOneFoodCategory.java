package design_pattern.factory_method_pattern;

public class MarketOneFoodCategory implements Shopping {
    @Override
    public void find() {
        System.out.println("market-one: food 검색 ");
    }

    @Override
    public void cart() {
        System.out.println("market-one: food 담기 ");
    }

    @Override
    public void order() {
        System.out.println("market-one: food 주문 ");
    }
}
