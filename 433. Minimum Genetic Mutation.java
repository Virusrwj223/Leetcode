//https://leetcode.com/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150
import java.util.Stack;
import java.util.Collection;
import java.lang.Integer;
import java.util.ArrayList;
class Solution {
    public boolean isNeighbour(String first, String second) {
        int counter = 1;
        for (int i = 0; i < first.length(); i++) {
            if(first.charAt(i) != second.charAt(i)) { 
                if (counter <= 0) return false;
                else counter--;
            }
        }
        return true;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        int endGeneNo = bank.length;
        Stack<Integer>[] adjMatrix = new Stack[bank.length+1];
        for (int i = 0; i < adjMatrix.length; i++) adjMatrix[i] = new Stack<Integer>();
        for (int i = 0; i < bank.length; i++) {
            if (isNeighbour(startGene, bank[i])) {
                adjMatrix[0].push(i+1);
                
            } 
        }
        boolean changed = false;
        for (int i = 0; i < bank.length; i++) {
            if (endGene.equals(bank[i])) {
                endGeneNo = i+1;
                changed = true;
            }
            for (int j = 0; j < bank.length; j++) {
                if (isNeighbour(bank[i], bank[j])) {
                    adjMatrix[i+1].push(j+1);
                }
            }
        }
        if (!changed) return -1;
        boolean[] visited = new boolean[bank.length+1];
        visited[0] = true;
        int counter = 1;
        Collection<Integer> frontier = new ArrayList<Integer>();
        while (!adjMatrix[0].isEmpty()) {
            int num = adjMatrix[0].pop();
            if (num == endGeneNo) return counter;
            else frontier.add(num);
        }
        while (!frontier.isEmpty()) {
            Collection<Integer> nextFrontier = new ArrayList<Integer>();
            counter++;
            for (Integer v:frontier) {
                while(!adjMatrix[v].isEmpty()) {
                    int num = adjMatrix[v].pop();
                    if (num == endGeneNo) return counter;
                    if (!visited[num]) {
                        visited[num] = true;
                        nextFrontier.add(num);
                    }
                }
            }
            frontier = nextFrontier;
        }
        return -1;
    }
}
