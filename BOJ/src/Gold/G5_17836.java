package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_17836 {
	
	private static class Point{
		int x, y, time;
		boolean gram;

		public Point(int x, int y, int time, boolean gram) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.gram=gram;
		}
		
	}
	
	static int N, M, T;
	static int[][] map;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
			
		find();
	}
	
	private static void find() {
		
		Queue<Point> queue=new ArrayDeque<>();
		queue.offer(new Point(0,0,0,false));
		boolean[][] visited = new boolean[N][M];
		boolean[][] visited2 = new boolean[N][M];
		boolean flag=false;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x=p.x;
			int y=p.y;
			visited[x][y]=true;			
			if(x==N-1&&y==M-1) {
				if(p.time>T) {
					System.out.println("Fail");
					return;
				}
				else {
					System.out.println(p.time);
					return;
				}
			}
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(0<=nx&&nx<N&&0<=ny&&ny<M) {
					
					if(!p.gram) {
						if(!visited[nx][ny]&&map[nx][ny]==0) {
							visited[nx][ny]=true;
							queue.offer(new Point(nx, ny, p.time+1, false));
						}
						else if(!visited[nx][ny]&&map[nx][ny]==2) {
							visited[nx][ny]=true;
							queue.offer(new Point(nx, ny, p.time+1, true));
							
						}
					}
					else {
						if(!visited2[nx][ny]) {
							visited2[nx][ny]=true;
							queue.offer(new Point(nx, ny, p.time+1, true));
						}
					}
				
						
				}
				else 
					continue;
				
			}
		}
		System.out.println("Fail");
		
	}
}
