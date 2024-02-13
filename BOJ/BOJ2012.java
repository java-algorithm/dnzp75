package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int N = Integer.parseInt((br.readLine()));
        int[] gradle = new int[N];

        for (int i = 0; i < N; i++) {
            gradle[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(gradle);

        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.abs(gradle[i] - (i + 1));
        }
        System.out.println(answer);
    }
}
