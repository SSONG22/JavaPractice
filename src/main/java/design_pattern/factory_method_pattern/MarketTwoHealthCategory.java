package design_pattern.factory_method_pattern;

public class MarketTwoHealthCategory implements Shopping {
    @Override
    public void find() {
        System.out.println("market-two: health 검색 ");
    }

    @Override
    public void cart() {
        System.out.println("market-two: health 담기 ");
    }

    @Override
    public void order() {
        System.out.println("market-two: health 주문 ");
    }
}
