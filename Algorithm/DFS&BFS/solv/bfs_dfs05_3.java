package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * BOJ : 바이러스
 * https://www.acmicpc.net/problem/2606
 * dfs 인접리스트로 해결
 *
**/
public class bfs_dfs05_3 {

    static int cptNum = 0;
    static ArrayList<Integer>[] mapList;
    static boolean[] visited;

    static int tCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cptNum = Integer.parseInt(br.readLine());
        int mapNum = Integer.parseInt(br.readLine());

        mapList = new ArrayList[cptNum + 1];
        visited = new boolean[cptNum + 1];

        // 인접리스트 초기화
        for (int i = 1; i < cptNum + 1; i++) {
            mapList[i] = new ArrayList<Integer>();
        }

        while (mapNum-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            mapList[x].add(y);
            mapList[y].add(x);
        }

        dfs(1);

        System.out.println(tCnt);
    }

    public static void dfs(int i) {
        visited[i] = true;

        for (int j = 0; j < mapList[i].size(); j++) {
            int next = mapList[i].get(j);
            if (!visited[next]) {
                tCnt++;
                dfs(next);
            }
        }
    }
}
