package swordtooffer;

/**
 * @description:https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。



示例:

现有矩阵 matrix 如下：

[
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。
 * @author: zhanghailang
 * @date: 2021-5-28 19:38
 */
public class NumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length <= 0){
            return false;
        }
        if (matrix[0].length <=0){
            return false;
        }
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        // for(int i = 0; i <= n; n ++){
        //     for(int j = 0; j <= m; j++){
        //         if (matrix[i][j] == target){
        //             return true;
        //         }
        //     }

        // }
        int t = 0;
        if(matrix[t][m] == target){
            return true;
        }
        while(t+1 <= n && m-1 >= 0){
            if(matrix[t][m] < target){
                t++;
            }else if(matrix[t][m] > target){
                m--;
            }
            else
            if(matrix[t][m] == target){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
  {1,   4,  7, 11, 15},
  {2,   5,  8, 12, 19},
  {3,   6,  9, 16, 22},
  {10, 13, 14, 17, 24},
  {18, 21, 23, 26, 30}
};
        int target = 20;
        System.out.println(findNumberIn2DArray(matrix,target));
        
    }
}