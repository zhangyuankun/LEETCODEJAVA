/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (29.81%)
 * Total Accepted:    8.9K
 * Total Submissions: 29.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                int swap=nums[i];
                nums[i]=nums[i-1];
                nums[i-1]=swap;
                return;
            }
        }
        for(int i=0;i<nums.length;i++){
            int swap=nums[i];
                nums[i]=nums[nums.length-i-1];
                nums[nums.length-i-1]=swap;
        }
        return;
    }
}

