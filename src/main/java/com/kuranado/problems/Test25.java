package com.kuranado.problems;

/**
 * 葛老板-金山云笔试
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-04-11 17:08
 */
public class Test25 {

    public static void main(String[] args) {
        // Test Sample 1
        // 0 1 0 0 1 0 1 0
        //int[] nums = new int[]{1, 0, 0, 0, 0, 1, 0, 0};
        //int day = 1;
        // Test Sample 2
        // 1 0 1 0 1 0 0 1
        // 0 0 0 0 0 1 1 0
        int[] nums = new int[]{1, 1, 1, 0, 1, 1, 1, 1};
        int day = 2;
        fun(nums, day);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void fun(int[] nums, int day) {
        for (int i = 0; i < day; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == 0) {
                    if (nums[j + 1] % 2 == 0) {
                        if (nums[j] % 2 == 0) {
                            nums[j] = 0b00;
                        } else {
                            nums[j] = 0b01;
                        }
                    } else {
                        if (nums[j] % 2 == 0) {
                            nums[j] = 0b10;
                        } else {
                            nums[j] = 0b11;
                        }
                    }
                    continue;
                }
                if (j == nums.length - 1) {
                    if (nums[j - 1] % 2 == 0) {
                        if (nums[j] % 2 == 0) {
                            nums[j] = 0b00;
                        } else {
                            nums[j] = 0b01;
                        }
                    } else {
                        if (nums[j] % 2 == 0) {
                            nums[j] = 0b10;
                        } else {
                            nums[j] = 0b11;
                        }
                    }
                    continue;
                }
                if (j < nums.length - 1) {
                    if ((nums[j - 1] % 2 == 0 && nums[j + 1] % 2 == 0) || (nums[j - 1] % 2 == 1 && nums[j + 1] % 2 == 1)) {
                        if (nums[j] % 2 == 0) {
                            nums[j] = 0b00;
                        } else {
                            nums[j] = 0b01;
                        }
                    } else {
                        if (nums[j] % 2 == 0) {
                            nums[j] = 0b10;
                        } else {
                            nums[j] = 0b11;
                        }
                    }
                }
            }
            for (int j = 0; j < nums.length; j++) {
                nums[j] >>= 1;
            }
        }
    }

    public static void fun2(int[] nums, int day) {
        for (int i = 0; i < day; i++) {
            for (int j = 0; j < nums.length; j++) {
                int left = j - 1;
                int right = j + 1;
                if (j == 0) {
                    subFun(nums, j, right);
                    continue;
                }
                if (j == nums.length - 1) {
                    subFun(nums, j, left);
                }
                if (nums[left] % 2 == nums[right] % 2) {
                    if (nums[j] % 2 == 0) {
                        nums[j] = 0b00;
                    } else {
                        nums[j] = 0b01;
                    }
                } else {
                    if (nums[j] % 2 == 0) {
                        nums[j] = 0b10;
                    } else {
                        nums[j] = 0b11;
                    }
                }
            }
            for (int j = 0; j < nums.length; j++) {
                nums[j] >>= 1;
            }
        }
    }

    private static void subFun(int[] nums, int j, int index) {
        if (nums[index] % 2 == 0) {
            if (nums[j] % 2 == 0) {
                nums[j] = 0b00;
            } else {
                nums[j] = 0b01;
            }
        } else {
            if (nums[j] % 2 == 0) {
                nums[j] = 0b10;
            } else {
                nums[j] = 0b11;
            }
        }
    }
}
