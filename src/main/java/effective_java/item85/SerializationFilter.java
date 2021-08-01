package effective_java.item85;

import java.io.*;

/*
https://ichi.pro/ko/jiglyeolhwa-pilteoling-javaui-jiglyeolhwa-haeje-chwiyagseong-boho-57845558473750
 */
public class SerializationFilter {
    public static void main(String[] args) throws Exception {

        //Serialization
        Employee emp = new Employee("Test Name", "Test Title");
        String filename = "employee.ser";
        FileOutputStream filewrite = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(filewrite);
        out.writeObject(emp);
        out.close();
        filewrite.close();

        //Deserialization

        /*
        FileInputStream fileread = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileread);
        Employee empread = (Employee) in.readObject();
        System.out.println(empread.name);
        System.out.println(empread.title);
        */

        // 개별 스트림을 위한 패턴 기반 필터
        FileInputStream fileread = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileread);

        /*
        // ObjectInputFilter - 패턴
        ObjectInputFilter filesOnlyFilter = ObjectInputFilter.Config.createFilter("!com.example.Employee;");
        in.setObjectInputFilter(filesOnlyFilter);
        Employee pattern = (Employee) in.readObject();

        // CustomClassFilter  - 클래스
        in.setObjectInputFilter(new CustomClassFilter());
        Employee clazz = (Employee) in.readObject();

        // CustomMethodFilter - 메서드
        in.setObjectInputFilter(CustomMethodFilter::classFilter);
        Employee method = (Employee) in.readObject();
        */

        // 람다식
        in.setObjectInputFilter(info -> ((info.serialClass() != null) && info.serialClass().getName().equals("com.example.Employee")) ? ObjectInputFilter.Status.REJECTED : ObjectInputFilter.Status.UNDECIDED);
        Employee rambda = (Employee) in.readObject();
        System.out.println(rambda.name);
        System.out.println(rambda.title);
        in.close();
        fileread.close();
    }
}
