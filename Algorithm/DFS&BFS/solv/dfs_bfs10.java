package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * BOJ : 이모티콘
 * https://www.acmicpc.net/problem/14226
 *
**/
public class dfs_bfs10 {
    static int S;
    static int minTime = Integer.MAX_VALUE;
    static boolean[][] visited = new boolean[2001][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());

        bfs();

        System.out.println(minTime);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(1, 0, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.num == S) {
                minTime = Math.min(minTime, now.time);
                return;
            }

            if (now.num > 0 && now.num < 2000) {
                // 복사기능
                if (!visited[now.num][now.num]) {
                    q.offer(new Node(now.num, now.time + 1, now.num));
                    visited[now.num][now.num] = true;
                }

                // 삭제 기능
                if (!visited[now.num-1][now.clbNum]) {
                    q.offer(new Node(now.num - 1, now.time + 1, now.clbNum));
                    visited[now.num - 1][now.clbNum] = true;
                }
            }

            if (now.clbNum > 0 && now.num + now.clbNum < 2000) {
                // 붙여넣기 기능
                if (!visited[now.num + now.clbNum][now.clbNum]) {
                    q.offer(new Node(now.num + now.clbNum, now.time + 1, now.clbNum));
                    visited[now.num + now.clbNum][now.clbNum] = true;
                }
            }
        }
    }

    public static class Node {
        int num;
        int time;
        int clbNum;

        public Node(int num, int time, int clbNum) {
            this.num = num;
            this.time = time;
            this.clbNum = clbNum;
        }
    }




}
