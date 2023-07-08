package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15651 {

	static int N,M;
	static int[] nums;
	static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		nums=new int[M];
		perm(0);
		System.out.println(sb);
	}
	
	private static void perm(int cnt) {
		if(cnt==M){
			for(int i=0;i<M;i++) {
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			nums[cnt]=i;
			perm(cnt+1);
		}
	}

}
