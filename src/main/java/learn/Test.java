package learn;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.f(0, 2);
    }

    public void f(int m, int n) {
        if (m == n) {
            System.out.println(" -----> ");
        }
        for (int i = m; i < n; i++) {
            f(i+1, n);
            System.out.println(i);
        }
    }
}
