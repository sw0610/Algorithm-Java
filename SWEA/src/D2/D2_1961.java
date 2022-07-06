package D2;

import java.util.Scanner;

public class D2_1961 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n=sc.nextInt();
			
			int[][] arr=new int[n][n];
			
			int[][] arr90=new int[n][n];
			int[][] arr180=new int[n][n];
			int[][] arr270=new int[n][n];

			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr90[i][j]=arr[n-j-1][i];
					arr180[i][j]=arr[n-i-1][n-j-1];
					arr270[i][j]=arr[j][n-i-1];
				}
			}
			
			System.out.println("#"+tc);
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				for(int j=0;j<n;j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				for(int j=0;j<n;j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();
			}
			
			
		}
	}
}