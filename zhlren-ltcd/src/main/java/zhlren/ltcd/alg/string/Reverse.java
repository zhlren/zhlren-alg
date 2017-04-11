package zhlren.ltcd.alg.string;

import org.junit.Test;

/**
 * Created by bjrenzhili on 17/4/11.
 */
public class Reverse {
    @Test
    public void test(){
        String s = "abc";
        System.out.println(reverseString(s,0,2));
    }

    public String reverseString(String s, int from, int to){
        char[] chars = s.toCharArray();
        while (from<to){
            char tmp = chars[from];
            chars[from++] = chars[to];
            chars[to--] = tmp;
        }
        return new String(chars);
    }
}
