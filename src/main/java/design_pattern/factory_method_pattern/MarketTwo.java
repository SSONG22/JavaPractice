package design_pattern.factory_method_pattern;

public class MarketTwo extends Shop{
    @Override
    Shopping selectCategory(String category) {
        System.out.println("THIS IS MARKET TWO.");
        if (category.equals("FOOD")) return new MarketTwoFoodCategory();
        if (category.equals("HEALTH")) return new MarketTwoHealthCategory();
        return null;
    }
}
