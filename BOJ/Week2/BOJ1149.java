package BOJ.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];

        String[] costs = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            dp[0][i] = Integer.parseInt(costs[i]);
        }

        for (int i = 1; i < n; i++) {
            costs = br.readLine().split(" ");
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + Integer.parseInt(costs[0]);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + Integer.parseInt(costs[1]);
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + Integer.parseInt(costs[2]);
        }

        int minCost = Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);

        System.out.println(minCost);
    }
}
