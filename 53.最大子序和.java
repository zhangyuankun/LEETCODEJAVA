/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (42.60%)
 * Total Accepted:    45.5K
 * Total Submissions: 104.2K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
/*      方法1：O(n)法
        ##int maxToCurr：遍历到目前包括当前遍历的数的最大值为多少
        ##maxToCurr[n]=Max(maxToCurr[n-1]+maxToCurr[n],nums[n])
        ##int max：目前最大值
        ##max[n]=Max(max[n-1],maxToCurr[n-1]) */
/*      int maxToCurr=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            maxToCurr=Math.max(maxToCurr+nums[i], nums[i]);
            max=Math.max(maxToCurr, max);
        }
        return max; */
        //方法2：分治法
        return maxSubArraySum(nums,0,nums.length-1);

    }

    private int maxCrossingSum(int[]nums,int l,int mid,int r){
        int lsum=Integer.MIN_VALUE,rsum=Integer.MIN_VALUE,sum=0;
        for(int i=mid;i>=l;i--){
            sum=sum+nums[i];
            if(sum>lsum) lsum=sum;
        }
        sum=0;
        for(int j=mid+1;j<=r;j++){
            sum=sum+nums[j];
            if(sum>rsum) rsum=sum;
        }
        return lsum+rsum;
    }

    private int maxSubArraySum(int[] nums,int l,int r){
        if(l==r) return nums[l];
        int mid = l + (r-l)/2;
        return Math.max(maxSubArraySum(nums, l, mid), Math.max(maxSubArraySum(nums,mid+1,r), maxCrossingSum(nums, l, mid, r)));
    }
}

