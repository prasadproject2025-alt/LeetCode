1import java.util.*;
2
3class Solution {
4    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
5
6        List<Integer>[] graph = new ArrayList[n];
7        for (int i = 0; i < n; i++) {
8            graph[i] = new ArrayList<>();
9        }
10
11        for (int[] e : invocations) {
12            graph[e[0]].add(e[1]);
13        }
14
15        // Find all suspicious methods
16        boolean[] suspicious = new boolean[n];
17
18        Queue<Integer> q = new LinkedList<>();
19        q.offer(k);
20        suspicious[k] = true;
21
22        while (!q.isEmpty()) {
23            int u = q.poll();
24
25            for (int v : graph[u]) {
26                if (!suspicious[v]) {
27                    suspicious[v] = true;
28                    q.offer(v);
29                }
30            }
31        }
32
33        // Check if any non-suspicious method invokes a suspicious one
34        for (int[] e : invocations) {
35            int u = e[0];
36            int v = e[1];
37
38            if (!suspicious[u] && suspicious[v]) {
39                List<Integer> ans = new ArrayList<>();
40                for (int i = 0; i < n; i++) {
41                    ans.add(i);
42                }
43                return ans;
44            }
45        }
46
47        // Remove suspicious methods
48        List<Integer> ans = new ArrayList<>();
49
50        for (int i = 0; i < n; i++) {
51            if (!suspicious[i]) {
52                ans.add(i);
53            }
54        }
55
56        return ans;
57    }
58}