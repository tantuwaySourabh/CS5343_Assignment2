package Q43;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 * 
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1
 * (inclusive). The edges in the graph are represented as a 2D integer array edges, where each
 * edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex
 * pair is connected by at most one edge, and no vertex has an edge to itself.
 * 
 * You want to determine if there is a valid path that exists from vertex source to vertex
 * destination.
 * 
 * Given edges and the integers n, source, and destination, return true if there is a valid path
 * from source to destination, or false otherwise.
 * 
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:s
 * - 0 → 1 → 2
 * - 0 → 2
 * 
 */
public class FindIfPathExist {
    private static boolean dfs(int src, int target, List<Integer>[] adj, boolean[] visited) {
        if (src == target)
            return true;

        visited[src] = true;
        for (int neighbor : adj[src]) {
            if (!visited[neighbor]) {
                boolean result = dfs(neighbor, target, adj, visited);
                if (result)
                    return true;
            }
        }
        return false;
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(source, destination, adj, visited);

    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1}, {1,2}, {2,0}};
        int source = 0;
        int destination = 2;

        System.out.println(validPath(n, edges, source, destination));
    }
}

/*
 * Let N be the number of nodes and M be the number of edges.
 * Time Complexity: O(N+M)
 * Space Complexity: O(N+M)
 */
