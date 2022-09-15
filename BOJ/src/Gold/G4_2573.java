package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 2573 ºù»ê

public class G4_2573 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] ice;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int res=1;
		while(true) {
			int piece=0;
			ice=new boolean[N][M];
			
			boolean flag=false;
			
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					if(map[i][j]>0) {
						find(i,j);
						flag=true;
					}
				}
			}
			
			if(!flag) {
				System.out.println(0);
				break;
			}
			else {
				for(int i=1;i<N-1;i++) {
					for(int j=1;j<M-1;j++) {
						if(map[i][j]==-1) {
							map[i][j]=0;
						}
						if(ice[i][j]) {
							bfs(i,j);
							piece++;
						}
					}
				}
				
				if(piece>=2) {
					System.out.println(res);
					break;
				}
				else {
					res++;
				}
			}

		}
		
	}
	

	
	private static void find(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(map[x][y]>0 && map[nx][ny]==0) {
				map[x][y]--;
			}
		}
		
		if(map[x][y]==0) {
			map[x][y]=-1;
		}
		else if(map[x][y]>0) {
			ice[x][y]=true;
		}
	}
	
	private static void bfs(int a, int b) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(a, b));
		ice[a][b]=false;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0;i<4;i++) {
				
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(ice[nx][ny] &&map[nx][ny]>0) {
					ice[nx][ny]=false;
					queue.offer(new Point(nx, ny));
				}
			}
			
		}
		
		
	}

}
