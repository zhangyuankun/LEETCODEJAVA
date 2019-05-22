/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<nums1.length;j++){
                if(nums1[j]>nums2[i]&&j<m){
                    for(int k=m;k>j;k--){
                        nums1[k] = nums1[k-1];
                    }
                    nums1[j]=nums2[i];
                    m++;
                    break;
                }else if(j>=m){
                    nums1[j]=nums2[i];
                    m++;
                    break;
                }
            }
        }
        return;
    }
}

