package BOJ.Week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ1976 {
    static int[] parent; // 부모 노드를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수
        parent = new int[N + 1];

        // 초기에 모든 도시의 부모를 자기 자신으로 설정
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 도시 간 연결 정보 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken())); // 여행 계획의 첫 번째 도시
        for (int i = 1; i < M; i++) {
            int next = find(Integer.parseInt(st.nextToken()));
            if (start != next) { // 첫 번째 도시와 연결되지 않은 도시가 있다면 여행 불가
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

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
}
