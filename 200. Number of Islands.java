//https://leetcode.com/problems/number-of-islands/
import java.util.*; 
class Solution {

    boolean[][] visited;
    int counter;
    char[][] grid;

    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    boolean canGo(Node node) {
        if (node.x >= 0 && node.x < grid[0].length && node.y >= 0 && node.y < grid.length) {
            return grid[node.y][node.x] == '1'; 
        }
        return false;
    }

    Node moveTo(Node node, int dir) {
        if (dir == 1) return new Node(node.x, node.y - 1);
        else if (dir == 2) return new Node(node.x + 1, node.y);
        else if (dir == 3) return new Node(node.x, node.y + 1);
        else return new Node(node.x - 1, node.y);
    }

    void bfs(Node node) {
        visited[node.y][node.x] = true;
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(node);
        while(!frontier.isEmpty()) {
            Queue<Node> nextFrontier = new LinkedList<>();
            while(!frontier.isEmpty()){
                Node n = frontier.poll();
                for (int i = 0; i < 4; i++) {
                    Node movedNode = moveTo(n, i);
                    if (canGo(movedNode) && !visited[movedNode.y][movedNode.x]) {
                        visited[movedNode.y][movedNode.x] = true;
                        nextFrontier.add(new Node(movedNode.x, movedNode.y));
                    }
                }
            }
            frontier = nextFrontier;
        }
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.counter = 0;
        this.visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Node n = new Node(j, i);
                //System.out.println(canGo(n));
                if (canGo(n) && !visited[i][j]) {
                    bfs(n);
                    counter++;
                }
            }
        }
        return counter;
    }
}
