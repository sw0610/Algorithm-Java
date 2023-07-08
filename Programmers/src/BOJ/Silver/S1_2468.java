package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2468 {
	
	static int N, cnt, total;
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	
	static int[][] map, copy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(min>map[i][j])
					min=map[i][j];
				if(max<map[i][j])
					max=map[i][j];
			}
		}
		
		for(int i=min-1;i<max;i++) {
			rain(i);
			total=Math.max(total, cnt);
		}
		System.out.println(total);
	}
	
	private static void rain(int x) {
		copy=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]<=x)
					copy[i][j]=1;
			}
		}
		cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copy[i][j]==0) {
					if(safe(i,j))
						cnt++;
				}
			}
		}
//		System.out.println(cnt);
		
	}
	
	private static boolean safe(int x, int y) {
		if(0<=x && x<N&& 0<=y&&y<N) {
			if(copy[x][y]==0) {
				copy[x][y]=1;
				safe(x-1, y);
				safe(x+1, y);
				safe(x, y-1);
				safe(x, y+1);
				return true;
			}
				
		}

		return false;
	}

}
