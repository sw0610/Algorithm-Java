package D4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_4193 {

	static int N, startX, startY, endX, endY, res;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Point> swirl;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			swirl = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
//					if(map[i][j]==2) {
//						swirl.add(new Point(i, j));
//					}
				}
			}

			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			res = -1;
			find();
			sb.append("#" + tc + " " + res + "\n");

		}
		System.out.println(sb);
	}

	private static void find() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(startX, startY));
		boolean[][] visited = new boolean[N][N];

		visited[startX][startY] = true;
		int t = 0;
		int k = 2;
		while (!queue.isEmpty()) {
			
			int size =  queue.size();
			for (int l = 0; l < size; l++) {

				Point p = queue.poll();
				int x = p.x;
				int y = p.y;

				if (x == endX && y == endY) {
					res = t;
					return;
				}

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (0 <= nx && nx < N && 0 <= ny && ny < N) {
						if (visited[nx][ny])
							continue;
						if (map[nx][ny] == 1) {
							continue;
						} 
						
						if (map[nx][ny] == 2) {
							if (t % 3 == 2) {
								map[nx][ny] = 0;
								queue.add(new Point(nx, ny));
							}else {
								visited[x][y]=true;
								queue.add(new Point(x, y));
							}
						} else if (map[nx][ny] == 0) {
							visited[nx][ny] = true;
							queue.add(new Point(nx, ny));
						}
					}
				}
			}
			t++;

		}
	}
}
