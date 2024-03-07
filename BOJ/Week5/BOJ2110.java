package BOJ.Week5;

// 공유기 설치
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 1; // 가능한 최소 거리
        int end = houses[N - 1] - houses[0]; // 가능한 최대 거리
        int answer = 0; // 최적의 공유기 사이 거리

        // 이진 탐색을 수행
        while (start <= end) {
            int mid = (start + end) / 2; // 중간값을 공유기 사이의 거리로 가정

            // 첫 번째 집에 공유기를 설치하고 시작
            int installed = 1;
            int lastInstalled = houses[0];

            // 다음 집부터 확인하며 공유기를 설치할 수 있는지 검사
            for (int i = 1; i < N; i++) {
                if (houses[i] - lastInstalled >= mid) {
                    installed++;
                    lastInstalled = houses[i];
                }
            }

            // 설치된 공유기 수가 C 이상이면 거리를 늘린다.
            if (installed >= C) {
                answer = mid; // 답을 업데이트합니다.
                start = mid + 1;
            } else { // 그렇지 않다면 거리를 줄여야 합니다.
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
