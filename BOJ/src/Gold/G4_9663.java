package Gold;

import java.util.Scanner;

public class G4_9663 {

	static int N, res;
	static int[] chess;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		chess=new int[N+1];
		
		res=0;
		nqueen(1);
		
		System.out.println(res);
	}
	
	private static void nqueen(int x) {
//		chess[x]=

		if(x>N) {
			res++;
			return;
		}
		
		for(int i=1;i<=N;i++) {
			chess[x]=i;
			if(isAvailable(x)) 
				nqueen(x+1);
		}
		
	}
	
	private static boolean isAvailable(int x) {
		for(int i=1;i<x;i++) {
			if(chess[i]==chess[x] || Math.abs(i-x)==Math.abs(chess[i]-chess[x]))
				return false;
		}
		return true;
		
		
	}

}
