package effective_java.item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Favorites f = new Favorites();

        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
        // Java cafebabe effective_java.item33.Favorites

        // 슈퍼 타입 토큰, Spring: ParameterizedTypeReference
//        List<String> pets = Arrays.asList("개", "고양이", "앵무");
//        f.putFavorite(new TypeRef<List<String>>() {
//        }, pets);
//        List<String> listofStrings = f.getFavorite(new TypeRef<List<String>>() {
//        });

    }

    // asSubclass를 사용해 한정적 타입 토큰을 안전하게 형변환한다.
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null; // 비한정적 타입 토큰
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}
