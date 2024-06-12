//https://leetcode.com/problems/course-schedule-ii/description/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;
import java.lang.*;


class Solution {
    boolean[] visited;
    boolean[] tvisited;
    ArrayList<Integer> courses;
    ArrayList<LinkedList<Integer>> adjList;
    boolean hasLoop;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<LinkedList<Integer>> adj_list = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adj_list.add(new LinkedList<Integer>());
        }

        int[] frequency = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] combi = prerequisites[i];
            int preq = combi[1];
            int post = combi[0];
            adj_list.get(preq).add(post);
            frequency[post] = frequency[post] + 1;
        }
        boolean hasZero = false;
        boolean[] visited = new boolean[numCourses];
        boolean[] tvisited = new boolean[numCourses];
        this.visited = visited;
        this.tvisited =tvisited;
        ArrayList<Integer> courses = new ArrayList<>();
        this.courses = courses;
        Queue<Integer> queue = new LinkedList<Integer>();
        this.adjList = adj_list;
        for (int i = 0; i < numCourses; i++) {
            if(frequency[i] == 0) {
                hasZero = true;
                queue.add(i);
            }
        }
        if (!hasZero) return new int[0];

        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            dfs(course);
            for (int i = 0; i < numCourses; i++) {
                if(!visited[i])queue.add(i);
            }
        }
        if (hasLoop) return new int[0];
        Collections.reverse(courses);
        int[] returnable = new int[courses.size()];
        for (int i = 0; i < returnable.length; i++) {
            returnable[i] = courses.get(i);
        }
        
        return returnable;
    }

    public void dfs(int course) {
        if (!visited[course]) {
            tvisited[course] = true;
            visited[course] = true;
            LinkedList<Integer> postReqs = adjList.get(course);
            while (!postReqs.isEmpty()) {
                Integer tcourse = postReqs.pop();
                dfs(tcourse);
            }
            tvisited[course] = false;
            courses.add(course);
        } else {
            if (tvisited[course]) hasLoop = true;
        }
    }
}
