package learn.dp;

public class Backpack {
    private int[] weight = {2, 2, 4, 6, 3};  //物品重量
    private int n = 5; // 物品个数
    private int maxWeight = 9; //背包承受的最大重量
    private int result = Integer.MIN_VALUE; //结果放到 result 中


//    //回溯算法, 时间复杂度O(2的n次方)
//    public void backTrack(int i, int currWeight) {
//        //currWeight==maxWeight 表示装满了，i==n 表示物品都考察完了
//        if (currWeight == maxWeight || i == n) {
//            if (currWeight > result) result = currWeight;
//            return;
//        }
//
//        //选择不装第i个物品
//        backTrack(i + 1, currWeight);
//
//        //没有超过背包可以承受的重量时, 才选择装入第i个物品
//        if (currWeight + weight[i] <= maxWeight) {
//            backTrack(i + 1, currWeight + weight[i]);
//        }
//    }

    //回溯算法, 避免重复计算
    private boolean[][] mem = new boolean[5][9];
    public void backTrackMemory(int i, int currWeight) {
        if (i == n || currWeight == maxWeight) {
            if (currWeight > result) result = currWeight;
            return;
        }

        //记录是否已计算过
        if (mem[i][currWeight]) return;
        mem[i][currWeight] = true;

        //选择不装第i个物品
        backTrackMemory(i+1, currWeight);
        //如果背包当前重量加上第i个物品的重量大于maxWeight, 才选择装入第i个物品
        if (weight[i]+currWeight <= maxWeight) {
            backTrackMemory(i+1, weight[i]+currWeight);
        }
    }

    public static void main(String[] args) {
        Backpack bp = new Backpack();
        //bp.backTrack(0, 0);
        bp.backTrackMemory(0, 0);
        System.out.println(bp.result);
    }
}
