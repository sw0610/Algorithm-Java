package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_1486 {

	static int N, B;
	static int[] nums;
	static boolean[] selected;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			nums = new int[N];
			selected = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

//			Arrays.sort(nums);

			res = Integer.MAX_VALUE;

			subset(0);
			sb.append("#" + tc + " " + res + "\n");

		}
		System.out.println(sb);
	}

	private static void subset(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					sum += nums[i];
				}
			}

			if (sum < B) {
				return;
			} else {
				res = Math.min(res, sum-B);

				return;
			}

		}

		selected[idx] = true;
		subset(idx + 1);
		selected[idx] = false;
		subset(idx + 1);

	}

}
