package SWEA.D2;

import java.util.HashSet;
import java.util.Scanner;

public class D2_1974 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int[][] arr = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			System.out.println("#" + tc + " " + check(arr));
		}

	}

	private static int check(int[][] mlist) {

		int ans = 1;
		int res = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				res += mlist[i][j];
			}

			if (res == 45) {
				ans = 1;
				res = 0;
			} else {
				return 0;
			}

		}

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {
				res += mlist[j][i];
			}
			if (res == 45) {
				ans = 1;
				res = 0;
			} else {
				return 0;
			}

		}

		for (int i = 0; i < 7; i += 3) {
			for (int j = 0; j < 7; j += 3) {

				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						res += mlist[x + i][y + j];

					}
				}
				if (res == 45) {
					ans = 1;
					res = 0;
				} else {
					return 0;
				}

			}
		}
		return 1;
	}

}
