import java.util.ArrayList;

import java.util.List;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (33.64%)
 * Total Accepted:    37.7K
 * Total Submissions: 111.9K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i=0,j=0,k=0;
        for(;(i<nums1.length+nums2.length)&&(j<nums1.length)&&(k<nums2.length);i++){{
                if(nums1[j]<=nums2[k]){
                    list.add(nums1[j]);
                    j++;
                }else{
                    list.add(nums2[k]);
                    k++;
                }
                if(j>nums1.length||k>nums2.length) break;
            }
        }
        if(j>=nums1.length){
            while(i<nums1.length+nums2.length){
                list.add(nums2[k]);
                k++;
                i++;
            }
        }else if(k>=nums2.length){
            while(i<nums1.length+nums2.length){
                list.add(nums1[j]);
                j++;
                i++;
            }
        }
        if(list.size()%2==0){
            return (double)(list.get(list.size()/2-1)+list.get(list.size()/2))/2;
        }else{
            return (list.get(list.size()/2));
        }
    }
}

