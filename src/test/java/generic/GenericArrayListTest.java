package generic;

import generic.ex.GenericArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenericArrayListTest {

    @DisplayName("제네릭을 사용하면")
    @Test
    void 제네릭_테스트(){
        GenericArrayList<Integer> intList = new GenericArrayList<>();
        intList.add(1);
        intList.add(2);
        int intValue1 = intList.get(0); // 형변환이 필요없다. -> 컴파일러가 형변환을 알아서 해준다.
        int intValue2 = intList.get(1); // 형변환이 필요없다.
//        String stringValue = intList.get(0); // 컴파일 에러 발생
    }
}