package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 求上面三角形从顶部到底部的最小路径, (2 + 3 + 5 + 1 = 11)
 */
public class Triangle {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(triangle.get(triangle.size() - 1));

        System.out.println(t.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //将三角形最后一行赋值给一个存放每行最小值的列表
        List<Integer> mini = triangle.get(triangle.size() - 1);

        //从倒数第二行开始往上逐行遍历
        for (int i = triangle.size() - 2; i >= 0 ; i--) {
            //在每一行中从左向右每列遍历
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //当前位置的值，加上它左下和右下中的较小者
                mini.set(j, triangle.get(i).get(j) + Math.min(mini.get(j), mini.get(j+1)));
            }
        }
        return mini.get(0);
    }
}
