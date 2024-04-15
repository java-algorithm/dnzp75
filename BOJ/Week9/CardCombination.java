package BOJ.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CardCombination {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 카드의 개수
        int m = Integer.parseInt(st.nextToken()); // 합체를 하는 횟수

        // 자연수가 쓰여진 카드들을 저장할 우선순위 큐 (최소 힙)
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 카드의 초기 상태 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        // m번 카드 합체하기
        for (int i = 0; i < m; i++) {
            long x = pq.poll(); // 가장 작은 수
            long y = pq.poll(); // 두 번째로 작은 수

            // x와 y를 합쳐서 다시 큐에 두 번 삽입
            long sum = x + y;
            pq.add(sum);
            pq.add(sum);
        }

        // 모든 카드의 합 계산
        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        // 결과 출력
        System.out.println(total);
    }
}
