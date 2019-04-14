import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 *
 * https://leetcode-cn.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (51.17%)
 * Total Accepted:    18.7K
 * Total Submissions: 36.5K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 
 * 
 * 上图是一个部分填充的有效的数独。
 * 
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * ⁠    但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 
 * 说明:
 * 
 * 
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * 
 * 
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean flag = false;
        ArrayList<ArrayList<ArrayList<Integer>>> a = new ArrayList<>();
        for(int i=0;i<board.length&&flag==false;i++){
            for(int j=0;j<board[i].length&&flag==false;j++){
                if(board[i][j]=='.') continue;
                else {
                    int k =-1;
                    switch (i) {
                        case 1:case 2:case 3:{
                            switch (j) {
                                case 1:case 2:case 3:{
                                    k=0;
                                    break;}
                                case 4:case 5:case 6:{
                                    k=1;
                                    break;}
                                case 7:case 8:case 9:{
                                    k=2;
                                    break;}
                                default:
                                    break;
                            }
                            
                            break;}
                        case 4:case 5:case 6:{
                            switch (j) {
                                case 1:case 2:case 3:{
                                    k=3;
                                    break;}
                                case 4:case 5:case 6:{
                                    k=4;
                                    break;}
                                case 7:case 8:case 9:{
                                    k=5;
                                    break;}
                                default:
                                    break;
                            }

                            break;}
                        case 7:case 8:case 9:{
                            switch (j) {
                                case 1:case 2:case 3:{
                                    k=6;
                                    break;}
                                case 4:case 5:case 6:{
                                    k=7;
                                    break;}
                                case 7:case 8:case 9:{
                                    k=8;
                                    break;}
                                default:
                                    break;
                            }
                            break;
                        }
                        default:k=-1;
                            break;
                    }
                    if(a.get(1).get(i).get(board[i][j])==null) a.get(1).get(i).set(board[i][j],1);
                    else flag=true;
                    if(a.get(2).get(j).get(board[i][j])==null) a.get(2).get(j).set(board[i][j],1);
                    else flag=true;
                    if(a.get(3).get(k).get(board[i][j])==null) a.get(3).get(k).set(board[i][j],1);
                    else flag=true;
                }
            }
        }
        return flag;
    }
}

