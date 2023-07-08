package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3234 {
	
	static int N, res;
	static int[] scale, nums;
	static boolean[] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		int T= Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			scale=new int[N];
			for(int i=0;i<N;i++){
				scale[i]=Integer.parseInt(st.nextToken());
			}
			
			res=0;
			nums=new int[N];
			selected=new boolean[N];
			perm(0);
			
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);
		
	}

	private static void perm(int cnt) {
		
		if(cnt==N) {
			find(0,0,0);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!selected[i]) {
				nums[cnt]=scale[i];
				selected[i]=true;
				perm(cnt+1);
				selected[i]=false;
			}
				
		}
		
	}
	
	private static void find(int idx, int left, int right) {
		if(idx==N) {
			res++;
			return;
		}
		find(idx+1, left+nums[idx], right);
		if(right+nums[idx]<=left) {
			find(idx+1, left, right+nums[idx]);
		}
	}
}
