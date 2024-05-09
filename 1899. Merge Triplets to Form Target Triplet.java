//https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for (int i = 0; i < 3; i++) {
            boolean exists = false;
            for (int j = 0; j < triplets.length; j++) {
                if (triplets[j] == null) continue;
                if (target[i] == triplets[j][i]) exists = true;
                if(target[i] < triplets[j][i]) triplets[j] = null;
            }
            if (!exists) return false;
        }
        
        for (int i = 0; i < 3; i++) {
            boolean exists = false;
            for (int j = 0; j < triplets.length; j++) {
                if (triplets[j] == null) continue;
                if (target[i] == triplets[j][i]) exists = true;
            }
            if (!exists) return false;
        }
        return true;
    }
}
