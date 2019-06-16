package geektime_algorithm.dynamic;

public class Backpack {
    private int maxWeight = Integer.MIN_VALUE;//所要求的结果
    private int[] item = {2, 2, 4, 6, 3};//物品重量
    private int n = 5;//物品个数
    private int weight = 9;//背包所能承受的最大重量
    private boolean[][] memory = new boolean[5][9];





    //回溯算法实现,并使用内存记录重复计算
    public void backtrackMemory(int i, int currentWeight) {
        if (currentWeight == weight || i == n) {
            if (currentWeight > maxWeight) maxWeight = currentWeight;
            return;
        }

        if (memory[i][currentWeight]) return;
        memory[i][currentWeight] = true;

        backtrackMemory(i+1, currentWeight);

        if (currentWeight + item[i] <= weight) {
            backtrackMemory(i+1, currentWeight+item[i]);
        }
    }


    //回溯算法实现
    public void backtrack(int i, int currentWeight) {
        //currentWeight == weight表示背包达到了所能承受的最大重量,i==n表示物品都遍历完了
        if (currentWeight == weight || i == n) {
            if (currentWeight > maxWeight) maxWeight = currentWeight;
            return;
        }

        //选择不装第i个物品
        backtrack(i+1, currentWeight);

        //选择装第i个物品
        if (currentWeight + item[i] <= weight) {
            backtrack(i+1, currentWeight + item[i]);
        }
    }

    public static void main(String[] args) {
        Backpack bp = new Backpack();
        //bp.backtrack(0, 0);
        bp.backtrackMemory(0, 0);
        System.out.println(bp.maxWeight);
    }
}
