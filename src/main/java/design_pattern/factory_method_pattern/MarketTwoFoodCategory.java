package design_pattern.factory_method_pattern;

public class MarketTwoFoodCategory implements Shopping {
    @Override
    public void find() {
        System.out.println("market-two: food 검색 ");
    }

    @Override
    public void cart() {
        System.out.println("market-two: food 담기 ");
    }

    @Override
    public void order() {
        System.out.println("market-two: food 주문 ");
    }
}
