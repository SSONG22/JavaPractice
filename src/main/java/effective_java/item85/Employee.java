package effective_java.item85;

import java.io.Serializable;

/*
https://ichi.pro/ko/jiglyeolhwa-pilteoling-javaui-jiglyeolhwa-haeje-chwiyagseong-boho-57845558473750
* */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    String title;

    public Employee() {
    }

    public Employee(String name, String title) {
        this.name = name;
        this.title = title;
    }
}
