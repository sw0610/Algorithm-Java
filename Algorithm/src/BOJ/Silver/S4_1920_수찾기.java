package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1920_수찾기 {

    static int N, M;
    static int[] arr, nums;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {

            if(binarySearch(nums[i]))
                sb.append("1\n");
            else
                sb.append("0\n");

        }

        System.out.println(sb);
    }

    private static boolean binarySearch (int num){
        int left = 0;
        int right = N - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (num < arr[mid]) {
                right = mid - 1;
            } else if (num > arr[mid]) {
                left = mid + 1;

            } else {
                return true;
            }

        }

        return false;

    }
}
