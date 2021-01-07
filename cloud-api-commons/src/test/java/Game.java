import java.lang.annotation.*;

/**
 * Description:
 * date: 2020-12-10
 *
 * @author xumu
 */
@Repeatable(People.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Game {
    String value() default "";
}
