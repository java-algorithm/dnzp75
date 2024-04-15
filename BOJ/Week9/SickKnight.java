package BOJ.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SickKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        // 체스판의 세로 길이가 1인 경우
        if (N == 1) {
            System.out.println(1);
        }
        // 세로 길이가 2인 경우
        else if (N == 2) {
            System.out.println(Math.min(4, (M + 1) / 2));
        }
        // 세로 길이가 3 이상이고 가로 길이가 7 미만인 경우
        else if (M < 7) {
            System.out.println(Math.min(4, M));
        }
        // 그 외의 경우
        else {
            System.out.println(M - 2);
        }
    }
}
