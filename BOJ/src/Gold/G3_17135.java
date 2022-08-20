package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class G3_17135 {
	
	static int N, M, D;
	static int[][] map, copy;
	static boolean[][] visited, gone;
	static int[] arrow;
	static int[] dx= {-1,0,1};
	static int[] dy= {0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arrow=new int[3];
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==3) {
			attack();
			return;
		}
		
		for (int i = start; i < M; i++) {
			arrow[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void attack() {
		gone = new boolean[N][M];
		for(int i=0;i<3;i++) {
			bfs(arrow[i], 0);
		}
		
	}
	
	private static void bfs(int pos, int depth) {
		if(depth>D) {
			return;
		}
		
		
		Queue<Point> queue= new LinkedList<>();
		
		queue.offer(new Point(N, pos));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x=p.x;
			int y=p.y;
			
			for(int i=0;i<3;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]) {
					if(map[nx][ny]==1&& !gone[nx][ny]) {
						visited[nx][ny]=true;
						gone[nx][ny]=true;
						return;
					}
					
					queue.offer(new Point(nx, ny));
					visited[nx][ny]=true;
				}
				
				
			}
			
		}
		
	}

}
