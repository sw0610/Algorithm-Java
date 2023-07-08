package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_10026 {

	static int N, res1, res2;
	static String[][] map, copy;
	static String ns;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		
		map= new String[N][N];
		copy= new String[N][N];
		
		for(int i=0;i<N;i++) {
			map[i]=br.readLine().split("");
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				if(map[i][j].equals("G")) {
					copy[i][j]="R";
				}
				else {
					copy[i][j]=map[i][j];
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j].equals("R")||map[i][j].equals("G")||map[i][j].equals("B")) {
					ns=map[i][j];
					find(i, j, map);
					res1++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copy[i][j].equals("R")||copy[i][j].equals("B")) {
					ns=copy[i][j];
					find(i, j, copy);
					res2++;
				}
			}
		}
		
		
		System.out.println(res1+" "+res2);
	}
	
	private static boolean find(int x, int y, String[][] color) {
		if(0<=x && x<N && 0<=y && y<N) {
			if(color[x][y].equals(ns)) {				
				color[x][y]="X";

				find(x+1, y, color);
				find(x, y+1, color);
				find(x, y-1, color);
				find(x-1, y,color);
				return true;
			}
		}
		return false;
	}

//	static int[] dx= {0,-1,0,1};
//	static int[] dy= {-1,0,1,0};
//	private static void find2(int x, int y, String[][] color) {
////		visited[x][y]=true;
//		String tmp=color[x][y];
//		color[x][y]="X";
//		
//		for(int i=0;i<4;i++) {
//			int nx=x+dx[i];
//			int ny=y+dy[i];
//			
//			if(0<=nx && nx<N && 0<=ny && ny<N) {
//				if(color[nx][ny].equals(tmp)) {				
//					find2(nx, ny, color);
//				}
//			}
//		}
//		
//	}

}
