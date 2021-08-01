package effective_java.item85;

import java.io.ObjectInputFilter;

public class CustomMethodFilter {
    static ObjectInputFilter.Status classFilter(ObjectInputFilter.FilterInfo info) {
        Class<?> serialClass = info.serialClass();
        if (serialClass != null) {
            return !(serialClass.getName().equals("com.example.Employee")) //serialClass.getPackageName().equals("com.example")
                    ? ObjectInputFilter.Status.ALLOWED
                    : ObjectInputFilter.Status.REJECTED;
        }
        return ObjectInputFilter.Status.UNDECIDED;
    }
}
