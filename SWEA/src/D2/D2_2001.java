package D2;

import java.util.ArrayList;
import java.util.Scanner;

public class D2_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int res = 0;

			int[][] mlist = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mlist[i][j] = sc.nextInt();
				}
			}

			int max = 0;

			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					res = 0;
					for (int k = 0; k < m; k++) {
						for (int w = 0; w < m; w++) {
							res += mlist[i + k][j + w];
						}
					}
					if (res > max) {
						max = res;
					}
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}