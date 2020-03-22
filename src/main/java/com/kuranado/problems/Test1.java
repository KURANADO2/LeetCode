package com.kuranado.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 1 两数之和
 *
 * @Author: Xinling Jing
 * @Date: 2020/3/15 17:51
 */
public class Test1 {

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        twoSum(a, 9);
        twoSum2(a, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                return new int[]{map.get(a), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

}
