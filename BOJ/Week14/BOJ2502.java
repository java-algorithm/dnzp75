package BOJ.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];

        for (int i = 1; i <= m / 2; i++) { // 첫날 떡의 개수 A
            for (int j = i + 1; j < m; j++) { // 둘째날 떡의 개수 B
                dp[0] = i;
                dp[1] = j;

                for (int k = 2; k < n; k++) {
                    dp[k] = dp[k - 1] + dp[k - 2];
                }

                if (dp[n - 1] == m) {
                    System.out.println(dp[0]);
                    System.out.println(dp[1]);
                    System.exit(0);
                }
            }
        }
    }
}