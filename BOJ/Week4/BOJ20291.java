package BOJ.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 확장자별 파일 개수를 저장하기 위한 HashMap 생성
        Map<String, Integer> extensionCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();

            // 파일 이름에서 확장자 부분 추출
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

            // 확장자를 key로 하여, 해당 확장자의 파일 개수를 세어 저장
            // 이미 존재하는 확장자라면 개수를 1 증가, 존재하지 않는다면 새로 추가
            extensionCount.put(extension, extensionCount.getOrDefault(extension, 0) + 1);
        }

        // 확장자를 사전 순으로 정렬하기 위한 List 생성 및 초기화
        List<String> sortedExtensions = new ArrayList<>(extensionCount.keySet());
        Collections.sort(sortedExtensions);

        // 정렬된 확장자 목록을 순회하며 확장자와 해당 확장자의 파일 개수를 출력
        for (String ext : sortedExtensions) {
            System.out.println(ext + " " + extensionCount.get(ext));
        }
    }
}
