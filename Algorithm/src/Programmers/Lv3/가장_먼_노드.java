package Programmers.Lv3;

import java.util.*;

class 가장_먼_노드 {
    static ArrayList<Integer>[] nodes;
    static int[] visited;
    public int solution(int n, int[][] edge) {
        int answer = 0;

        nodes = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            nodes[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<edge.length;i++){
            int[] e = edge[i];
            nodes[e[0]].add(e[1]);
            nodes[e[1]].add(e[0]);
        }

        visited = new int[n+1];

        bfs();
        int max = 0;
        for(int i=1;i<n+1;i++){
            max = Math.max(visited[i], max);
        }
        for(int i=1;i<n+1;i++){
            if(visited[i]==max){
                answer++;
            }
        }

        return answer;
    }

    public void bfs(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = 1;
        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int i:nodes[x]){
                if(visited[i]==0){
                    visited[i] = visited[x]+1;
                    queue.add(i);
                }
            }

        }
    }

}