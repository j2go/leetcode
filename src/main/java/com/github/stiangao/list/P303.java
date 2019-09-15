package main.java.com.github.stiangao.list;

/**
 * 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class P303 {

    static class NumArray {
        final int[] sumArr;
        public NumArray(int[] nums) {
            int n = nums.length;
            sumArr = new int[n+1];
            for(int i=0;i<n;i++){
                sumArr[i+1] = sumArr[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {

            return sumArr[j+1] - sumArr[i];
        }
    }

}
