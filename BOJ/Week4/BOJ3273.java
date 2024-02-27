package BOJ.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // StringTokenizer를 사용하여 한 줄에 여러 입력을 받음
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        // 수열 정렬
        Arrays.sort(arr);

        int count = 0;
        int start = 0;
        int end = n - 1;

        // 투 포인터 사용
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {
                count++;
                start++;
            } else if (sum < x) {
                // 합이 x보다 작으면 합을 증가시켜야 하므로 시작 포인터 오른쪽으로 이동
                start++;
            } else {
                // 합이 x보다 크면 합을 감소시켜야 하므로 종료 포인터 왼쪽으로 이동
                end--;
            }
        }

        System.out.println(count);
    }
}
