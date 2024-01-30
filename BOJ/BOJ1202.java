package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1202 {

    static int N, K;
    static long answer = 0;
    static int[] bag;
    static jewel[] jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bag = new int[K];
        jewels = new jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new jewel(V, M);
        }

        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bag[i] = C;
        }

        Arrays.sort(bag);
        Arrays.sort(jewels);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N) {
                if (bag[i] < jewels[j].weight) {
                    break;
                }
                pq.add(jewels[j++].price);
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class jewel implements Comparable<jewel> {

        int price, weight;

        public jewel(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }

        @Override
        public int compareTo(jewel o) {
            if (this.weight == o.weight) {
                return o.price - this.price;
            }
            return this.weight - o.weight;
        }
    }
}
