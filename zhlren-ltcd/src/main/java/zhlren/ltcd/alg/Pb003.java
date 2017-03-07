package zhlren.ltcd.alg;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bjrenzhili on 17/3/7.
 */
public class Pb003 {

    @Test
    public void test() {
        String input = "nfpdmpi";
        lengthOfLongestSubstring(input);
    }

    public int lengthOfLongestSubstring(String s) {
        List<Character> characterList = new LinkedList<Character>();
        if (null != s && !"".equals(s.trim())) {
            char[] chars = s.toCharArray();
            int maxLength = 0;
            int curLength = 0;
            for (int i = 0; i < chars.length; i++) {
                int oldIdx = characterList.indexOf(chars[i]);
                characterList.add(chars[i]);
                if (oldIdx < 0) {
                    //**之前没有该元素*/
                    curLength++;
                    maxLength = Math.max(curLength, maxLength);
                }
                else {
                    //**之前有该元素*/
                    maxLength = Math.max(curLength, maxLength);
                    curLength = curLength - oldIdx;
                    //**移除 起点至原重复元素*/
                    for (int j = 0; j < oldIdx + 1; j++) {
                        characterList.remove(0);
                    }
                }
            }
            return maxLength;
        }
        return 0;
    }

}
