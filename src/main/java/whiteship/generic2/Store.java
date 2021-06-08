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

        System.out.println(appleDao.getEntityClass());
//        GenericDao<Banana, Integer> bananaDao = new GenericDao<>();
//  상위 클래스가 오브젝트 타입이기 때문에 getEntityClass() 가 나오지 않는다.
        BananaDao bananaDao = new BananaDao();
        System.out.println(bananaDao.getEntityClass());
    }
}
