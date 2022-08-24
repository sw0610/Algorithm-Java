package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_16236 {
	
	static class fish{
		int x, y, d, p;

		public fish(int x, int y, int d, int p) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.p = p;
		}
		
	}
	
	static int N, map[][], time;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					eat(i, j);
				}
			}
		}
		
		
	}

	private static void eat(int a, int b) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(a, b));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					if(map[nx][ny]==map[x][y]) {
						queue.offer(new Point(nx, ny));
					}
					else if(map[nx][ny]<map[x][y]) {
						
					}
				}
			}
		}
	}

}
