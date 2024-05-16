package BOJ.Week14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1890 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(br.readLine());

        long[][] dp = new long[num + 1][num + 1];

        dp[1][1] = 1;

        for (int i = 1; i <= num; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            for (int j = 1; j <= num; j++) {
                int moveLength = Integer.parseInt(stringTokenizer.nextToken());

                if (dp[i][j] >= 1 && moveLength != 0) {
                    if (j + moveLength <= num) {
                        dp[i][j + moveLength] += dp[i][j];
                    }

                    if (i + moveLength <= num) {
                        dp[i + moveLength][j] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[num][num]);

    }
}
