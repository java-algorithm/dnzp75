package BOJ.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2606 {

    static List<Integer>[] network;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int connection = Integer.parseInt(br.readLine());

        network = new ArrayList[computer + 1];
        visited = new boolean[computer + 1];

        for (int i = 1; i <= computer; i++) {
            network[i] = new ArrayList<>();
        }

        for (int i = 0; i < connection; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a].add(b);
            network[b].add(a);
        }

        dfs(1);

        System.out.println(count - 1);
    }

    static void dfs(int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        count++;

        for (int next : network[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
