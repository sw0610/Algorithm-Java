package D2;

import java.util.ArrayList;
import java.util.Scanner;

public class D2_1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = 0;
			int k = 0;

			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					n = sc.nextInt();
				} else {
					k = sc.nextInt();
				}
			}

			int[][] mlist = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mlist[i][j] = sc.nextInt();
				}
			}

			int cnt = 0;
			int res = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mlist[i][j] == 1) {
						cnt += 1;
					}
					if (mlist[i][j] == 0 || j == n - 1) {
						if (cnt == k) {
							res += 1;
						}
						cnt = 0;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mlist[j][i] == 1) {
						cnt += 1;
					}
					if (mlist[j][i] == 0 || j == n - 1) {
						if (cnt == k) {
							res += 1;
						}
						cnt = 0;
					}
				}
			}

			System.out.println("#" + tc + " " + res);
		}
	}
}