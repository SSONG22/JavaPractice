package effective_java.item15;

import org.junit.jupiter.api.Test;

/* https://www.geeksforgeeks.org/final-arrays-in-java/ */
class ArrayIsTest {

    @Test
    void test1() {
        final ArrayIs a = new ArrayIs();
        a.p = 30;
        System.out.println(a.p);

        final ArrayIs b = new ArrayIs();
        ArrayIs c = new ArrayIs();
//        b = c;  컴파일 에러
    }

    @Test
    void test2() {
        final int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {10, 20, 30, 40, 50};
        arr2 = arr1;
//        arr1 = arr2; // 컴파일 에러
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}