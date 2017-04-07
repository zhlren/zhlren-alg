package zhlren.ltcd.alg;

import org.junit.Test;

/**
 * Created by bjrenzhili on 17/4/6.
 */
public class Pb91 {

    public int decode() {
        String s = "102315647102";
        int result = 0;
        if (s != null) {
            s = s.trim();
            if (s.length() > 0) {
                //** 存储每一位数字 */
                int[] numbers = new int[s.length()];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Character.getNumericValue(s.charAt(i));
                }
                result = dfs(numbers, 0, numbers.length - 1);
                System.out.println(result);
            }
        }
        return result;
    }

    public int dfs(int[] numbers, int begin, int end) {
        if (begin > end) {
            return 1;
        }
        else {
            if (numbers[begin] == 0) {
                return 0;
            }
            if (begin == end) {
                return 1;
            }
        }
        //** 第二位是0 只能取前两位一起 */
        if (numbers[begin + 1] == 0) {
            if (numbers[begin] * 10 + numbers[begin + 1] <= 26 && numbers[begin] * 10 + numbers[begin + 1] > 0) {
                return dfs(numbers, begin + 2, end);
            }
            return 0;
        }
        int result = dfs(numbers, begin + 1, end);
        if (numbers[begin] * 10 + numbers[begin + 1] <= 26 && numbers[begin] * 10 + numbers[begin + 1] > 0) {
            result += dfs(numbers, begin + 2, end);
        }
        return result;
    }

    @Test
    public void test2(){
        String s = "10253100451";
        System.out.println(decode2(s));
    }

    public int decode2(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int f2 = 1;
        int f1 = (s.charAt(0) == '0' ? 0 : 1);
        for (int i = 2; i <= s.length(); i++) {
            int f = (s.charAt(i - 1) == '0' ? 0 : f1);
            int tmp = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (tmp >= 10 && tmp <= 26) {
                f += f2;
            }
            f2 = f1;
            f1 = f;
        }
        return f1;
    }

}
