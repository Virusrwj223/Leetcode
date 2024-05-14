//https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;
class Solution {
    ArrayList<Integer>[] adjMatrix;
    boolean[] visited;
    int[] indegree;
    Queue<Integer> seq;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        adjMatrix = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjMatrix[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][1] == prerequisites[i][0]) return false;
            Integer preRequisite = prerequisites[i][1];
            Integer postRequisite = prerequisites[i][0];
            adjMatrix[preRequisite].add(postRequisite);
            indegree[postRequisite] = indegree[postRequisite] + 1;
        }
       
        
        visited = new boolean[numCourses];
        seq = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                seq.add(i);
            }
        }
        while(!seq.isEmpty()) {
            int number = seq.remove();
            visited[number] = true;
            ArrayList<Integer> neighbours = adjMatrix[number];
            
            for (int i = 0; i < neighbours.size(); i++) {
                indegree[neighbours.get(i)] = indegree[neighbours.get(i)] - 1;
                if(indegree[neighbours.get(i)] == 0) {
                    seq.add(neighbours.get(i));
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
