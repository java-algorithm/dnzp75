package BOJ.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {

    static int[] parent; // 각 원소의 부모 노드를 저장하는 배열

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); // 경로 압축 적용
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA; // 한 집합의 루트를 다른 집합의 루트로 설정하여 합침
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 원소의 개수
        int m = Integer.parseInt(st.nextToken()); // 연산의 개수

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i; // 초기에 각 원소의 부모는 자기 자신
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operation == 0) {
                union(a, b);
            } else if (operation == 1) {
                // 같은 집합에 속해 있는지 확인하는 연산
                System.out.println((find(a) == find(b)) ? "YES" : "NO");
            }
        }
    }
}
