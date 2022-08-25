package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_16236 {

	static class Fish implements Comparable<Fish> {
		int x, y, d, p;

		public Fish(int x, int y, int d, int p) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.p = p;
		}

		@Override
		public int compareTo(Fish o) {

			return 0;
		}

	}

	static int N, map[][], time, size = 2;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static ArrayList<Fish> small;
	static int[][] dis;
	static int minX, minY, eatCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		int x = 0;
		int y = 0;

		small = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = i;
					y = j;
					map[i][j]=0;
				}
			}
		}

		
		while(true) {
			dis = new int[N][N];
			minX=N+1;
			minY=N+1;
			eat(x, y);
			if(minX!=N+1 && minY!=N+1) {
				eatCnt++;
				map[minX][minY]=0;
				time+=dis[minX][minY];
				x=minX;
				y=minY;
				if(eatCnt==size) {
					eatCnt=0;
					size++;
				}
						
			}else {
				break;
			}
		}
		
		System.out.println(time);
		

	}


	private static void eat(int a, int b) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(a, b));
		int minD=Integer.MAX_VALUE;
		int min=9;

		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;

			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N&&map[nx][ny]<=size&&dis[nx][ny]==0) {
					dis[nx][ny]=dis[x][y]+1;
					if(map[nx][ny]!=0&&map[nx][ny]<size) {
						if(minD>dis[nx][ny]) {
							minD=dis[nx][ny];
							minX=nx;
							minY=ny;
						}
						else if(minD==dis[nx][ny]) {
							if(minX==nx) {
								if(minY>ny) {
									minY=ny;
								}
							}
							else if(minX>nx){
								minX=nx;
								minY=ny;
							}
								
						}
					}
					queue.offer(new Point(nx, ny));
				}
			}
			

		}
		
	}



}
