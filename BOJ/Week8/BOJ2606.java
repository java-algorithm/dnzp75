package BOJ.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606 {

    static int[] parent; // 각 노드의 부모 노드를 저장하는 배열

    // Find 함수: 특정 원소가 속한 집합을 찾음
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    // Union 함수: 두 원소가 속한 집합을 합침
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX; // 루트 노드를 연결하여 집합을 합침
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b); // 네트워크 상에서 직접 연결된 컴퓨터들을 같은 집합으로 합침
        }

        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (find(1) == find(i)) { // 1번 컴퓨터와 같은 집합에 속한 컴퓨터의 수를 찾음
                count++;
            }
        }

        System.out.println(count);
    }
}
