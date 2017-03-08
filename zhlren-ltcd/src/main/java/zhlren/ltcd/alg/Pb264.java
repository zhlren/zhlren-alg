package zhlren.ltcd.alg;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bjrenzhili on 17/3/8.
 */
public class Pb264 {

    public int nthUglyNumber(int n) {
        if (n < 1 || n > 1690) {
            return -1;
        }

        List<Integer> uglyNumberList = new LinkedList<Integer>();
        uglyNumberList.add(1);

        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        int count = 1;
        while (count < n) {
            int t2 = uglyNumberList.get(idx2) * 2;
            int t3 = uglyNumberList.get(idx3) * 3;
            int t5 = uglyNumberList.get(idx5) * 5;

            int min = Math.min(t2, Math.min(t3, t5));

            if (min == t2) {
                idx2++;
            }
            if (min == t3) {
                idx3++;
            }
            if (min == t5) {
                idx5++;
            }
            uglyNumberList.add(min);
            count++;
        }
        return uglyNumberList.get(n - 1);
    }

}
