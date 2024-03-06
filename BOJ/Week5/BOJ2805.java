package BOJ.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무 자르기
public class BOJ2805 {

    public static void main(String[] ags) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] trees = new long[N];
        long max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long start = 0;
        long end = max;
        long H = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    count += trees[i] - mid;
                }
            }

            if (count >= M) {
                H = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(H);
    }
}
