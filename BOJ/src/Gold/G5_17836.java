package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_17836 {
	
	private static class Point{ //현재 위치와 정보 저장 위한 클래스
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
		
		//
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
		// input
		find();
	}
	
	private static void find() {//bfs 이용해서 탐색
		
		Queue<Point> queue=new ArrayDeque<>();
		queue.offer(new Point(0,0,0,false));
		boolean[][] visited = new boolean[N][M];//그람이 없을 때
		boolean[][] visited2 = new boolean[N][M];//그람이 있을 때
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x=p.x;
			int y=p.y;
			visited[x][y]=true;	

			if(x==N-1&&y==M-1) {//공주님의 위치에 도달했을 때
				if(p.time>T) {//시간이 초과되었다면
					System.out.println("Fail");//fail 출력
					return;
				}
				else {//시간 내로 도착했다면
					System.out.println(p.time);//걸린 시간 출력
					return;
				}
			}
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(0<=nx&&nx<N&&0<=ny&&ny<M) {
					
					if(!p.gram) {//만약 그람이 없는 경우라면
						if(!visited[nx][ny]&&map[nx][ny]==0) {
							visited[nx][ny]=true;//방문위치 표시
							queue.offer(new Point(nx, ny, p.time+1, false));//현재 위치 정보 저장
						}
						else if(!visited[nx][ny]&&map[nx][ny]==2) {//그람이 있는 곳에 왔다면
							visited[nx][ny]=true;
							queue.offer(new Point(nx, ny, p.time+1, true));//그람이 있으므로 true 저장
							
						}
					}
					else {//그람이 있는 경우라면
						if(!visited2[nx][ny]) {
							visited2[nx][ny]=true;//방문 위치 표시
							queue.offer(new Point(nx, ny, p.time+1, true));
						}
					}
				
						
				}
				else 
					continue;
				
			}
		}
		System.out.println("Fail");//만약 공주의 위치까지 가지 못하고 끝날 경우 fail 출력
		
	}
}
