import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (54.06%)
 * Total Accepted:    10.8K
 * Total Submissions: 19.9K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> resulti = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j!=0&&j!=i) resulti.add(result.get(j-1)+result.get(j));
                else resulti.add(1);
            }
            result = resulti;
        }
        return result;
    }
}

