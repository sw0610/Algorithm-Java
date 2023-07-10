package Programmers.Lv2;

import java.util.*;
import java.awt.Point;

class 무인도여행 {

    static char[][] map;
    static ArrayList<Integer> answer;
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public ArrayList<Integer> solution(String[] maps) {
        answer = new ArrayList<>();
        N = maps.length;
        map = new char[N][];

        for(int i=0;i<N;i++){
            map[i] = maps[i].toCharArray();
        }

        M = map[0].length;
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!='X' && !visited[i][j]){
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        if(answer.isEmpty()){
            answer.add(-1);
        }
        else{
            Collections.sort(answer);
        }

        return answer;
    }

    public static void bfs(int a, int b){
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(a, b));
        int res = 0;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            res+=map[x][y]-'0';

            for(int i=0;i<4;i++){

                int nx = x+dx[i];
                int ny = y+dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(map[nx][ny]!='X' && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        answer.add(res);

    }
}