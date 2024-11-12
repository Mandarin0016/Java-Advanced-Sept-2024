package reflection_demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Докато програмата се изпълнява, JVM ще вижда тази анотация
@Retention(RetentionPolicy.RUNTIME)
public @interface Positive {
}
