package BOJ.Week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 랜선 자르기
public class BOJ1654 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] cables = new long[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
            if (max < cables[i]) {
                max = cables[i];
            }
        }

        long start = 1;
        long end = max;
        long result = 0;

        // 이진 탐색 시작
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            // 각 랜선을 현재 길이(mid)로 잘라서 총 몇 개의 랜선을 만들 수 있는지 계산
            for (int i = 0; i < K; i++) {
                count += cables[i] / mid;
            }

            // 필요한 랜선의 개수(N) 이상 만들 수 있으면 결과 업데이트, 더 긴 길이 탐색
            if (count >= N) {
                result = mid;
                start = mid + 1; // 더 긴 길이도 가능한지 확인
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
