package zhlren.ltcd.alg;

import org.junit.Test;

/**
 * Created by bjrenzhili on 17/3/22.
 */
public class Pb215 {

    @Test
    public void test() {
        int[] nums = { -1,2, 0 };
        quickSort(nums, 2);
    }

    public int quickSort(int[] nums, int k) {

        if (k <= 0 || k > nums.length) {
            return -1;
        }
        int result = partition(nums, k, 0, nums.length - 1);
        return result;
    }

    private int partition(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[k - 1];
        }
        int left = start, right = end;
        int flag = nums[left];
        while (left < right) {
            while (nums[right] <= flag && right > left) {
                right--;
            }
            if (left < right){
                nums[left++] = nums[right];
            }
            while (nums[left] > flag && left < right) {
                left++;
            }
            if (left < right){
                nums[right--] = nums[left];
            }
        }
        nums[left] = flag;
        if (left == k - 1  ) {
            return nums[left];
        }
        else if (left > k - 1) {
            return partition(nums, k, start, left-1);
        }
        else {
            return partition(nums, k, left+1, end);
        }
    }

}
