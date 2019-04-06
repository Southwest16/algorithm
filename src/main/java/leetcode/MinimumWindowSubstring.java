package leetcode;

public class MinimumWindowSubstring {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String ss , String tt) {
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();
        if (t.length == 0) {
            return "";
        }

        int[] cntS = new int[256]; // number of appearances for each character in the window
        int[] cntT = new int[256]; // how many times each character appears in T
        int K = 0; // number of T's unique chracters
        for (int i = 0; i < 256; ++i) {
            cntS[i] = cntT[i] = 0;
        }

        for (char c : t) {
            ++cntT[c];
            if (cntT[c] == 1) {
                ++K;
            }
        }

        // abccba ==> K=3
        int now = 0; // number of T's unique characters the window contains
        // when now == K, we're good

        int ansl = -1, ansr = -1;
        int l, r = 0;
        for (l = 0; l < s.length; ++l) { // main pointer, st
            // insert into window
            while (r < s.length && now < K) {
                ++cntS[s[r]];
                // phase jump
                if (cntS[s[r]] == cntT[s[r]]) {
                    ++now;
                }

                ++r;
            }

            if (now == K) {
                // this window is good
                if (ansl == -1 || r - l < ansr - ansl) {
                    ansl = l;
                    ansr = r;
                }
            }

            // remove from window
            --cntS[s[l]];
            if (cntS[s[l]] == cntT[s[l]] - 1) {
                --now;
            }
        }

        // s[l...(r-1)]
        if (ansl == -1) {
            return "";
        }
        else {
            return ss.substring(ansl, ansr);
        }
    }
}
