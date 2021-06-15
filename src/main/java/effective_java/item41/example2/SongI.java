package effective_java.item41.example2;

import java.lang.annotation.*;

// meta annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SongI {
}
