/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode-cn.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (35.71%)
 * Total Accepted:    9.4K
 * Total Submissions: 26.5K
 * Testcase Example:  '[1,2,0]'
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 
 * 
 * 说明:
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 1;
        if(nums.length==1){
            if(nums[0]==1) return 2;
            else return 1;
        }
        int i=0;
        while(i<nums.length){
            if(nums[i]==i+1||nums[i]<1||nums[i]>nums.length||nums[nums[i]-1]==nums[i]) i++;
            else{
                int mid = nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=mid;
            }
        }
        i=0;
        while(i<nums.length&&nums[i]==i+1) i++;
        return i+1; 
    }
}

