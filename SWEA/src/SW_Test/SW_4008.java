package SW_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_4008 {
	
	static int N;
	static int[] ops, nums;
	static int min, max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			ops = new int[4];
			for(int i=0;i<4;i++) {
				ops[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			nums = new int[N];
			for(int i=0;i<N;i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			calc(ops[0], ops[1], ops[2], ops[3], nums[0], 1);
			sb.append("#"+tc+" "+(max-min)+"\n");
		}
		System.out.println(sb);
	}
	
	private static void calc(int plus, int minus, int mul, int div, int res, int idx) {
//		if(plus==0 && minus==0 && mul==0 && div==0) {
//			
//		}
		if(idx==N) {
			min = Math.min(min, res);
			max = Math.max(max, res);
			return;
		}

		if(plus>0) {
			calc(plus-1,minus, mul, div, res+nums[idx],idx+1);		
		}
		if(minus>0) {
			calc(plus,minus-1, mul, div, res-nums[idx],idx+1);			
		}
		if(mul>0) {
			calc(plus,minus, mul-1, div, res*nums[idx],idx+1);			
		}
		if(div>0) {
			calc(plus,minus, mul, div-1, res/nums[idx],idx+1);			
		}

	}

}
