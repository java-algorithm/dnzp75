package BOJ.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChocolateMeal {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int k=Integer.parseInt(br.readLine());
        int size=1; // 구매할 초콜릿의 크기
        int size2=0; // 최종적으로 구매해야 할 초콜릿의 크기
        int count=0; // 초콜릿을 쪼개는 횟수

        while(size < k) {
            size*=2;
            size2=size;
        }

        while(k>0) {
            if(k<size) {
                size/=2;
                count++;
            }
            else {
                k-=size;
            }
        }

        System.out.println(size2+" "+count);
    }
}
