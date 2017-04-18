import java.util.HashMap;
import java.util.Map;

/**
 * Created by bjrenzhili on 17/4/14.
 */
public class Test {

    @org.junit.Test
    public void test(){
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        map.put(new Integer(1),true);
        map.put(1000,true);
        System.out.println(map.get(new Integer(1)));
        System.out.println(map.get(1000));
    }

}
