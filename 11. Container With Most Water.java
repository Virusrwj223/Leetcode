//https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
import java.lang.Math;
import java.util.function.Supplier;
class Solution {
    int[] height;
    public int max_v_f(int L, int R) {
        return Math.min(height[L],height[R])*(R-L);
    }
    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        this.height = height;
        int max_v = max_v_f(L,R);
        while (R > L) {
            if (height[L] < height[R]) {
                L += 1;
                if (max_v_f(L,R) > max_v) {
                    max_v = max_v_f(L,R);
                }
            } else if (height[L] > height[R]) {
                R -= 1;
                if (max_v_f(L,R) > max_v) {
                    max_v = max_v_f(L,R);
                }
            } else {
                L += 1;
                R -= 1;
                if (max_v_f(L,R) > max_v) {
                    max_v = max_v_f(L,R);
                }
            }
        }
        System.out.println(L);
        System.out.println(R);
        System.out.println("^^^^^^^^^^^^^^^^");
        return max_v;
        
    }
}
