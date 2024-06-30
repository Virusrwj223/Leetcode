//https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int[] net = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            net[i] = gas[i] - cost[i];
        }
        if (costSum > gasSum) return -1;

        int currStart = 0;
        int currSum = 0;
        for (int i = 0; i < net.length; i++) {
            if (currSum < 0) {
                currStart = i;
                currSum = 0;
            }
            currSum += net[i];
        }
        return currStart;
    }
}
