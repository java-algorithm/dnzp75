package BOJ.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용돈 관리
public class BOJ6236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N];
        int maxMoney = 0, sum = 0;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            maxMoney = Math.max(maxMoney, money[i]);
            sum += money[i];
        }

        // 이진 탐색 범위 설정: 하루 최대 금액 ~ 전체 금액 합
        int start = maxMoney;
        int end = sum;
        int answer = sum;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(money, mid, M)) { // 이 금액으로 M번 이내에 충당 가능한지 확인
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // 주어진 금액으로 모든 지출을 M번의 인출로 처리할 수 있는지 확인
    public static boolean isPossible(int[] money, int k, int m) {
        int count = 1;
        int currentSum = 0;

        for (int expense : money) {
            if (currentSum + expense > k) {
                count++;
                currentSum = 0;
            }
            currentSum += expense;
        }

        return count <= m;
    }
}
