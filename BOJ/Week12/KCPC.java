package BOJ.Week12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class KCPC {
    static class Team {
        int id;
        int[] scoreList;
        int submitNum;
        int lastSubmit;
        int totalScore;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T = 0; T < testCase; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 수
            int k = Integer.parseInt(st.nextToken()); // 문제의 수
            int t = Integer.parseInt(st.nextToken()); // 내 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그의 개수

            Team[] list = new Team[n]; // 팀들을 저장할 배열 생성

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamID = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (list[teamID - 1] == null) {
                    list[teamID - 1] = new Team();
                    list[teamID - 1].id = teamID;
                    list[teamID - 1].scoreList = new int[k + 1];
                }

                // 문제의 최고 점수 업데이트
                list[teamID - 1].scoreList[problemNum] = Math.max(score, list[teamID - 1].scoreList[problemNum]);

                list[teamID - 1].submitNum++;
                list[teamID - 1].lastSubmit = i;
            }

            // 모든 팀의 총 점수를 계산
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += list[i].scoreList[j]; // 문제별 최고 점수들을 합산
                }
                list[i].totalScore = sum; // 팀의 총 점수 설정
            }

            // 팀들을 정렬
            Arrays.sort(list, new Comparator<Team>() {

                @Override
                public int compare(Team o1, Team o2) {
                    if (o1.totalScore == o2.totalScore) {
                        if (o1.submitNum == o2.submitNum) {
                            return o1.lastSubmit - o2.lastSubmit; // 제출 횟수와 마지막 제출 시간에 따라 순위 결정
                        }
                        return o1.submitNum - o2.submitNum; // 제출 횟수가 적은 팀이 상위
                    }
                    return o2.totalScore - o1.totalScore; // 점수가 높은 팀이 상위
                }
            });

            // 내 팀의 순위를 찾아 출력
            for (int i = 0; i < n; i++) {
                if (list[i].id == t) {
                    bw.append(String.valueOf(i + 1) + "\n"); // 순위 출력
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
