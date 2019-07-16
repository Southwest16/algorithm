package learn.backtrack;

public class EightQueen {
    int[] result = new int[4];//全局成员变量, 下标表示行, 值表示皇后存储在那一列

    public void cal(int row) {
        if (row == 4) {
            print(result);
            return;
        }

//        System.out.println(row);
//        System.out.println(0 +" "+ 1 +" "+ 2 +" "+ 3);
//        System.out.println(result[0] +" "+ result[1] +" "+ result[2] +" "+ result[3]);
//        System.out.println();

        //每行都有8种放法
        for (int column = 0; column < 4; column++) {
            //判断是否满足要求
            if (isOK(row, column)) {
                //第row行的皇后放到了第column列
                result[row] = column;

                System.out.println(row +" "+ column);
                System.out.println(0 +" "+ 1 +" "+ 2 +" "+ 3);
                System.out.println(result[0] +" "+ result[1] +" "+ result[2] +" "+ result[3]);
                System.out.println();

                //放置下一行
                cal(row+1);
            }
        }
    }

    //判断row行colum列的皇后放置是否满足要求
    public boolean isOK(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;

        for (int i = row-1; i >= 0; i--) {
            if (result[i] == column) return false;//判断第i行第column列是否有皇后

            //判断左上角是否有皇后
            if (leftup >= 0)
                if (result[i] == leftup) return false;

            //判断右上角是否有皇后
            if (rightup < 4)
                if (result[i] == rightup) return false;

            leftup--;
            rightup++;
        }
        return true;
    }

    public void print(int[] result) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (result[i] == j){
                    System.out.print("z  ");
                } else {
                    System.out.print("o  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        queen.cal(0);
    }
}