package BOJ.Week1_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1781 {

    static int n;
    static Question[] questionArr;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        questionArr = new Question[n];

        // O(n)
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int cupNoodleCount = Integer.parseInt(st.nextToken());
            questionArr[i] = new Question(deadLine, cupNoodleCount);
        }

        long nowCupNoodleCount = 0;
        Arrays.parallelSort(questionArr);

        // O(n)
        for (Question question : questionArr) {
            int size = pq.size();
            if (size < question.deadLine) {
                pq.offer(question.cupNoodleCount);
            } else if (size == question.deadLine) {
                int noodleCount = pq.peek();
                if (noodleCount < question.cupNoodleCount) {
                    pq.poll();
                    pq.offer(question.cupNoodleCount);
                }
            }
        }

        // O(상수) -> 무시
        while (!pq.isEmpty()) {
            nowCupNoodleCount += pq.poll();
        }
        System.out.println(nowCupNoodleCount);
    }

    static class Question implements Comparable<Question> {

        int deadLine;
        int cupNoodleCount;

        Question(int deadLine, int cupNoodleCount) {
            this.deadLine = deadLine;
            this.cupNoodleCount = cupNoodleCount;
        }

        @Override
        public int compareTo(Question o) {
            // 1. 데드라인 낮은 순
            // 2. 컵라면 개수 높은 순
            if (this.deadLine < o.deadLine) {
                return -1;
            } else if (this.deadLine == o.deadLine) {
                if (this.cupNoodleCount > o.cupNoodleCount) {
                    return -1;
                } else if (this.cupNoodleCount == o.cupNoodleCount) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
}
