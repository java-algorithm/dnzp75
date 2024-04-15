package BOJ.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SkippingLogs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] arr;

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            arr = new int[N];

            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int right = N - 1;
            int left = 0;
            int[] nums = new int[N];

            // 왼쪽과 오른쪽에 하나씩 정렬된 통나무를 교차 배치
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    nums[right--] = arr[i];
                } else {
                    nums[left++] = arr[i];
                }
            }

            // 인접한 것들끼리의 크기 비교
            int answer = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                answer = Math.max(answer, Math.abs(nums[i] - nums[i - 1]));
            }

            // 처음과 끝 통나무도 크기 비교
            answer = Math.max(answer, Math.abs(nums[0] - nums[N - 1]));
            System.out.println(answer + " ");
        }
    }
}
