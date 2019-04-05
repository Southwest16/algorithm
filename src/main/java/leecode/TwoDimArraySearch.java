package leecode;

/**
 * 二维数组中查找给定的元素
 */
public class TwoDimArraySearch {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6}};
        int rows = array.length;        //行数
        int columns = array[0].length;  //列数

        System.out.println(search_2(3, array));
    }

    public static boolean search_2(int n, int[][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) return false;
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j <= array[0].length - 1){
            if (n > array[i][j]) {
                j++;
            } else if (n < array[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
