package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3234_2 {
	
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		
		int T= Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			int[] scale=new int[N];
			for(int i=0;i<N;i++){
				scale[i]=Integer.parseInt(st.nextToken());
			}
			
			res=0;
			int[] nums=new int[N];
			boolean[] selected=new boolean[N];
			perm(0, 0, 0, scale, selected,N);
			
			sb.append("#"+tc+" "+res+"\n");
			
		}
		System.out.println(sb);
	}

	private static void perm(int cnt, int left, int right, int[] scale, boolean[] selected, int N) {
		if(right>left) {
			return;
		}
		
		if(cnt==N) {
			res++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!selected[i]) {
				selected[i]=true;
				perm(cnt+1, left+scale[i], right, scale, selected, N);
				perm(cnt+1, left, right+scale[i], scale, selected, N);
				selected[i]=false;
			}
		}
	}
}
