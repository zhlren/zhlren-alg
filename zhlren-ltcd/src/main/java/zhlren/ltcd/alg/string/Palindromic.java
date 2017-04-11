package zhlren.ltcd.alg.string;

/**
 * 查找最长回文串
 * Created by bjrenzhili on 17/4/11.
 */
public class Palindromic {

    public String dpLongestPalindrome(String s) {

        if (null == s || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        String longest = null;
        for (int l=0;l<s.length();l++){
            for (int i=0;i<len-l;i++){
                int j = i +1;

            }
        }
        return null;
    }
}
