package Gold;

//import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_17135 {

	static class Point{
		int x, y, d;
		
		public Point(int x, int y, int d) {
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	
	static int N, M, D, res, max=Integer.MIN_VALUE;
	static int[][] map, copy;
	static boolean[][] visited, avisit;
	static int[] arrow;
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited=new boolean[N][M];
		arrow = new int[3];
		comb(0,0);
		System.out.println(max);
	}

	public static void comb(int cnt, int start) {
		if (cnt == 3) {
//			System.out.println(Arrays.toString(arrow));
			copy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
				}
			}
			attack();
			max=Math.max(res, max);
			return;
		}

		for (int i = start; i < M; i++) {
			arrow[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void attack() {
		res=0;
		while(true) {
			visited=new boolean[N][M];
			
			int isOne=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(copy[i][j]==1) {
						isOne++;
					}
				}
			}
			
			if(isOne==0) {
				return;
			}

			for (int i = 0; i < 3; i++) {
				bfs(N, arrow[i]);
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//						
//					System.out.print(visited[i][j]+"\t");
//				}
//				System.out.println();
//				
//			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copy[i][j]==1) {
					if(visited[i][j]==true) {
//						System.out.println(i+" "+j);
						copy[i][j]=0;
						res++;
					}
//
				}
				}
			}
			
			for(int i=N-1;i>0;i--) {
				for(int j=0;j<M;j++) {
					copy[i][j]=copy[i-1][j];
				}
			}
			for(int i=0;i<M;i++)
				copy[0][i]=0;
//			System.out.println("-----------");
		}
	}

	private static void bfs(int posX, int posY) {


		avisit=new boolean[N+1][M];
		avisit[posX][posY]=true;
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(posX, posY, 0));
		
		int depth=0;

		while (!queue.isEmpty()) {
			
			if(depth>D)
				return;
//			ArrayList<Distance> dis = new ArrayList<>();
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
//			int MinC=Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nd = p.d+1;
				if (0 <= nx && nx < N && 0 <= ny && ny < M ) {
					if(nd>D) 
						continue;
					if(avisit[nx][ny])
						continue;
					if (copy[nx][ny] == 1&& nd<=D) {
						
//						System.out.println(posX+" "+posY+" "+nx+" "+ny);
//						if(dis.size()>0) {
//							if(ny<dis.get(0).x) {
//								visited[nx][ny]=true;
//								visited[dis.get(0).x][dis.get(0).y]=false;
//								dis.remove(0);
//							}
//						}
//						dis.add(new Distance(nx, ny, depth));
						visited[nx][ny] = true;
						return;
					}
//					if(i==3&&dis.size()==1)
//						return;
					
					queue.offer(new Point(nx, ny, nd));
					avisit[nx][ny]=true;

//					visited[nx][ny] = true;
				}

			}
//			depth++;

		}
	}

}
