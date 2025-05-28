import java.util.*;

public class Solution {
    public int maxwt(int n, List<List<Integer>> edges, int k, int t) {
        List<List<int[]>> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            li.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1), w = edge.get(2);
            li.get(v).add(new int[]{u, w});
        }

        boolean[][] fast = new boolean[n][t];
        boolean[][] slow = new boolean[n][t];

        for (int i = 0; i < n; i++) {
            fast[i][0] = true;
        }

        for (int i = 1; i <= k; i++) {
            for (int v = 0; v < n; v++) {
                Arrays.fill(slow[v], false);
                for (int[] edge : li.get(v)) {
                    int u = edge[0], w = edge[1];
                    for (int wt = 0; wt + w < t; ++wt) {
                        if (fast[u][wt]) {
                            slow[v][wt + w] = true;
                        }
                    }
                }
            }

            boolean[][] temp = fast;
            fast = slow;
            slow = temp;
        }

        for (int wt = t - 1; wt >= 0; --wt) {
            for (int v = 0; v < n; ++v) {
                if (fast[v][wt]) {
                    return wt;
                }
            }
        }

        return -1;
    }
}
