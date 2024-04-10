package BOJ.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우선순위 큐를 활용한 다익스트라 알고리즘을 사용
public class BOJ18352 {

    static int n;
    static int[] table;
    static int A, B = 0;
    static ArrayList<ArrayList<Integer>> graph; // 각 도시에서 갈 수 있는 다른 도시

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 시작 도시 1로부터 각 도시까지의 최단 거리 저장하기 위한 배열
        table = new int[n + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(table, (int) 1e9);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        table[x] = 0;

        dijkstra(x);

        int cnt = 0;
        for (int i = 1; i < table.length; i++) {
            if (table[i] == k) {
                System.out.println(i);
                cnt++;
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.offer(start);
        while (!que.isEmpty()) {
            A = que.poll();
            for (int B = 0; B < graph.get(A).size(); B++) {
                int cost = table[A] + 1;
                if (cost < table[graph.get(A).get(B)]) {
                    table[graph.get(A).get(B)] = cost;
                    que.offer(graph.get(A).get(B));

                }
            }
        }
    }
}
