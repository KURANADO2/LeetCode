package com.kuranado.problems;

/**
 * 1111. 有效括号的嵌套深度
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-04-01 21:46
 */
public class Test20 {

    public static void main(String[] args) {
        // Test Sample 1
        String seq = "(()())";
        // Test Sample 1
        //String seq = "()(())()";
        int[] result = maxDepthAfterSplit(seq);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        char[] seqArr = seq.toCharArray();
        for (int i = 0; i < seqArr.length; i ++) {
            if (seqArr[i] == '(') {
                // 偶数位的左括号给 A，奇数位的左括号给 B
                ans[i] = i & 1;
            } else {
                // 偶数位的右括号给 B，奇数位的右括号给 A
                ans[i] = (i + 1) & 1;
            }
        }
        return ans;
    }
}
