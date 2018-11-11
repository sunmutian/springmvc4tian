package com.tian.sort.list;

/**
 * @auther: tianweichang
 * @date: 2018/11/6 14
 * @Description: 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class LeedCode0001 {
    public static int[] findEquals(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
          /*  if (target >= 0 && nums[i] > target) {
                continue;
            }
            if (target < 0 && nums[i] < target) {
                continue;
            }*/
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {-18, 12, 3, 0, -5};

        int target = -6;
        int[] n = findEquals(nums, target);
        System.out.println(n[0] + " " + n[1]);
    }
}
