package BOJ.Week14;

import java.util.Scanner;

public class PrefixSum_X {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n의 값 입력
        int m = sc.nextInt(); // m의 값 입력

        int[] arr = new int[n]; // 크기 n의 숫자 배열 선언
        for (int i = 0; i < n; i++) { // 크기 n의 배열에 각 숫자 입력
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < m; i++) { // m번 구간 합을 구하기 위한 반복문
            sum = 0;
            int a = sc.nextInt(); // 구간 합을 구할 구간의 시작점 입력
            int b = sc.nextInt(); // 구간 합을 구할 구간의 끝점 입력
            for (int j = a - 1; j < b; j++) { // 시작점부터 끝점까지 합을 구하기 위한 반복문
                sum += arr[j];
            }
            System.out.println(sum); // 구간 합 출력
        }
    }
}
