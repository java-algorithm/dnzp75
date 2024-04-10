package BOJ.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724 {

    static int[] root;

    public static int find(int x) {
        if (root[x] == x) {
            return x;
        } else {
            return find(root[x]);
        }
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX; // 루트 노드를 연결하여 집합을 합침
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            root[i] = i; // 초기에 각 정점의 루트는 자기 자신
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        int componentCount = 0;
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {
                componentCount++; // 각 정점이 자신을 가리키는 경우, 연결 요소의 대표자임
            }
        }

        System.out.println(componentCount); // 연결 요소의 개수 출력
    }
}
