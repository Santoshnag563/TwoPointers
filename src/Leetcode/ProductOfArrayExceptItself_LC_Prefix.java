package Leetcode;


/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

Solution:
1. calculate prefix
2. calculate postfix
3. calculate product with postfix and prefix
 */

import java.util.Arrays;

public class ProductOfArrayExceptItself_LC_Prefix {

    public static void main(String[] args) {
        int[] arr = {4,3,2,1,2};
        productExceptSelf(arr);
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] result = new int[nums.length];

        prefix[0] = nums[0];
        postfix[nums.length-1] = nums[nums.length-1];

        for(int i = 1; i< nums.length; i++) {
            prefix[i] = nums[i] * prefix[i-1];
        }

        for(int i = nums.length-2; i>=0; i--) {
            postfix[i] = nums[i] * postfix[i+1];
        }


        int i = 0;
        result[i] = postfix[1];
        result[nums.length-1] = prefix[nums.length-2];
        for(i = 1; i< nums.length-1; i++) {
            System.out.println(prefix[i-1]+"   "+postfix[i+1]);
            result[i] = prefix[i-1] * postfix[i+1];
        }

        return result;

    }
}
