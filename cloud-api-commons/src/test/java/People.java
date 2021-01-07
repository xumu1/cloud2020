import java.lang.annotation.*;

/**
 * Description:
 * date: 2020-12-10
 *
 * @author xumu
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface People {
    Game[] value() ;
}
