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

    /**
     * 快排
     * @param nums
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[k - 1];
        }
        int left = start, right = end;
        int flag = nums[left];
        /**循环直至left=right*/
        while (left < right) {
            /**从右侧开始找一个大于flag的*/
            while (nums[right] <= flag && right > left) {
                right--;
            }
            /**找到则放到左侧*/
            if (left < right){
                nums[left++] = nums[right];
            }
            /**从左侧开始找一个小于等于flag的*/
            while (nums[left] > flag && left < right) {
                left++;
            }
            /**找到则放到右侧*/
            if (left < right){
                nums[right--] = nums[left];
            }
        }
        /**flag放中间*/
        nums[left] = flag;
        /**当前flag为第k大*/
        if (left == k - 1  ) {
            return nums[left];
        }
        /**当前flag索引大于k 目标在左半侧*/
        else if (left > k - 1) {
            return partition(nums, k, start, left-1);
        }
        /**当前flag索引小于k 目标在右半侧*/
        else {
            return partition(nums, k, left+1, end);
        }
    }

}
