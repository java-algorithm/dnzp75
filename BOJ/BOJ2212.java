package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2212 {

    static int N, K;
    static int[] position;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        position = new int[N];

        for (int i = 0; i < N; i++) {
            position[i] = Integer.parseInt(st.nextToken());
        }

        if (K >= N) {
            System.out.println(0);
            return;
        }
        Arrays.sort(position);

        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = position[i + 1] - position[i];
        }
        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < diff.length - K + 1; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}
