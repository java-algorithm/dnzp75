package BOJ.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int M, N, H;
    static int[][][] box;
    static Queue<Tomato> queue = new LinkedList<>();

    static class Tomato {

        int x, y, z;

        Tomato(int z, int y, int x) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.add(new Tomato(h, n, m));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                int nz = t.z + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = box[t.z][t.y][t.x] + 1;
                        queue.add(new Tomato(nz, ny, nx));
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        return -1;
                    }
                    result = Math.max(result, box[h][n][m]);
                }
            }
        }

        if (result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }
}
