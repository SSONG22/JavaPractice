package design_pattern.factory_method_pattern;

public abstract class Shop {
    // Shop 은 공통 행위(shopping) 의 주체 이다.

    public Shopping shopping(String category){
        Shopping shopping = selectCategory(category);
        shopping.find();
        shopping.cart();
        shopping.order();
        return shopping;
    }

    // factory method
    abstract Shopping selectCategory(String category);
}
