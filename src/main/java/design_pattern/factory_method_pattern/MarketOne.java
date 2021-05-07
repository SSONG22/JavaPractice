package design_pattern.factory_method_pattern;

public class MarketOne extends Shop {
    @Override
    Shopping selectCategory(String category) {
        System.out.println("THIS IS MARKET ONE.");
        if (category.equals("FOOD")) return new MarketOneFoodCategory();
        if (category.equals("HEALTH")) return new MarketOneHealthCategory();
        return null;
    }
}
