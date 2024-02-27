package BOJ.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Counting Sort :  값의 범위 + 1만큼의 크기를 가진 배열 생성 (0 사용 안 함)
        int[] count = new int[10001];

        for (int i = 0; i < N; i++) {
            // 입력 받은 값을 인덱스로 하는 count 배열의 값을 증가
            count[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();

        // 1부터 시작하여 count 배열을 순회하며 정렬된 결과를 생성
        for (int i = 1; i < 10001; i++) {
            while (count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }
        System.out.println(sb);
    }
}
