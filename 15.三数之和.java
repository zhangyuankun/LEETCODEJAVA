import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (20.77%)
 * Total Accepted:    37.2K
 * Total Submissions: 178.5K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 三个数，第一个base，第二个和第三个双指针扫描，求nums-i
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int target = 0-nums[i];
            for(int j=i+1,k=nums.length-1;j<k;){
                if(nums[j]+nums[k]==target){
                    List<Integer> listNow = new ArrayList<>();
                    listNow.add(nums[i]);
                    listNow.add(nums[j]);
                    listNow.add(nums[k]);
                    result.add(listNow);
                }
                if(nums[j]+nums[k]<target){
                    do{
                        j++;
                        if(j>=k) break;
                    }while(nums[j]==nums[j-1]);
                }else do{
                    k--;
                    if(k<=j) break;
                }while(nums[k]==nums[k+1]);
            }
            while(i<nums.length-2&&nums[i+1]==nums[i]) i++;
        }
        return result;
    }
}

