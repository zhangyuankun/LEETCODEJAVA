import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int now = nums[i]+nums[j]+nums[k];
                    if(((result-target)*(result-target))>((now-target)*(now-target))){
                        result=now;
                    }
                }
            }
        }
        return result;
    }
}

