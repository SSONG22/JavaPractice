package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class CloneArrayListTest {

    /**
     * mutable 한 내부 객체(리스트)의 문제를 해결하기 위해서는
     * 깊은 복사(Deep Copy)를 해야 한다.
     */
    @DisplayName("단순 복사와 얕은복사의 차이는 얕은 복사는 복합객체를 별도로 생성한다는 점이다")
    @Test
    void 단순복사_VS_얕은복사() {
        // 단순복사
        ArrayList<Integer> A_List = new ArrayList<>(); // ArrayList@ 1596
        A_List.add(1);
        A_List.add(2);
        ArrayList<Integer> B_List = A_List; // ArrayList@ 1596

        System.out.println("A의 HashCode " + A_List.hashCode() + " : B의 HashCode " + B_List.hashCode() + " equals " + (A_List == B_List));
        // A의 HashCode 994 : B의 HashCode 994 equals true

        // 얕은 복사
        ArrayList<Integer> C_List = (ArrayList<Integer>) A_List.clone(); // ArrayList@ 1597
        System.out.println("A의 HashCode " + A_List.hashCode() + " : C의 HashCode " + C_List.hashCode() + " equals " + (A_List == C_List));
        // A의 HashCode 994 : C의 HashCode 994 equals false
    }

    @DisplayName("clone 메서드는 얕은 복사본을 만드는데 사용한다.")
    @Test
    void ArrayList의_clone는_shallow_copy() {
        ArrayList<Integer> original = new ArrayList<>(); // ArrayList@ 1593
        for (int i = 0; i < 10; i++) original.add(i);
        ArrayList<Integer> cloneArrayList = (ArrayList<Integer>) original.clone(); // ArrayList@ 1594

        Assertions.assertEquals(original, cloneArrayList); // SUCCESS

        Assertions.assertEquals(original.hashCode(), cloneArrayList.hashCode());
        System.out.println(original.hashCode() + " : " + cloneArrayList.hashCode()); // -1631921466 : -1631921466
//        Assertions.assertNotEquals(original, cloneArrayList); // FAIL
    }

    @DisplayName("객체의 Deep Copy 는 iterator 를 써서 값을 복사 해보자")
    @Test
    void ArrayList의_deep_copy_Class객체복사() {

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1l, "adam", new Date(2021, 04, 13)));
        System.out.println(employeeList); // [Employee{id=1, name='adam', dob=Fri May 13 00:00:00 KST 3921}]

        ArrayList<Employee> employeeListClone = new ArrayList<>();

        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            try {
                employeeListClone.add((Employee) iterator.next().clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        employeeListClone.get(0).setId(2l);
        employeeListClone.get(0).setName("brian");
        employeeListClone.get(0).getDob().setDate(13);
        ;

        System.out.println(employeeList); // [Employee{id=1, name='adam', dob=Fri May 13 00:00:00 KST 3921}]
        System.out.println(employeeListClone); // [Employee{id=2, name='brian', dob=Fri May 13 00:00:00 KST 3921}]

        Assertions.assertNotEquals(employeeList, employeeListClone); // SUCCESS
        Assertions.assertNotEquals(employeeList.hashCode(), employeeListClone.hashCode()); // SUCCESS
    }


}
