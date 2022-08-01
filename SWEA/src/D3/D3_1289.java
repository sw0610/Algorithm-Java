package D3;

import java.util.Scanner;

public class D3_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			char[] m = sc.next().toCharArray();
			int[] x = new int[m.length];
			for (int i = 0; i < m.length; i++) {
				if (x[i] != m[i] - '0') {
					for (int j = i; j < x.length; j++) {
						x[j] = m[i] - '0';
					}
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
