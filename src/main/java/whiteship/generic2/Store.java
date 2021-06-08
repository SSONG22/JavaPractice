package whiteship.generic2;

import java.util.List;

public class Store {
    public static void main(String[] args) {
//        AppleDao appleDao = new AppleDao();
        GenericDao<Apple, Integer> appleDao = new GenericDao<>(); // appleDao 클래스가 아예 필요없다.

        appleDao.save(Apple.of(1));
        appleDao.save(Apple.of(2));

        List<Apple> all= appleDao.findAll();
        for(Apple apple : all)
            System.out.println(apple);
        all.forEach(System.out::println);
    }
}
