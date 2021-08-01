package effective_java.item85;

import java.io.ObjectInputFilter;

public class CustomClassFilter implements ObjectInputFilter {
    @Override
    public Status checkInput(FilterInfo filterInfo) {
        Class<?> clazz = filterInfo.serialClass();
        if (clazz != null) {
            return !(clazz.getName().equals("com.example.Employee")) ? Status.ALLOWED : Status.REJECTED; //clazz.getPackage().equals("com.example")
        }
        return Status.UNDECIDED;
    }
}
