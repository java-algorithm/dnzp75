package BOJ.Week14;

import java.util.Scanner;

public class PrefixSum_O {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n의 값 입력
        int m = sc.nextInt(); // m의 값 입력

        int[] psum = new int[n+1]; // 부분 합을 저장할 배열 생성
        psum[0] = 0; // 0번째 인덱스는 0으로 초기화
        for (int i = 1; i <= n; i++) {
            psum[i] = psum[i-1] + sc.nextInt(); // 합으로 배열 생성
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // a의 값 입력
            int b = sc.nextInt(); // b의 값 입력
            System.out.println(psum[b] - psum[a - 1]); // 부분 합을 이용하여 구간 합 출력
        }
    }
}
