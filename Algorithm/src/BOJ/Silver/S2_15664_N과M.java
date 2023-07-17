package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_15664_N과M {

    static int N, M;
    static int[] nums, selectedNums;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        selectedNums = new int[M];
        comb(0,0);
        System.out.println(sb);
    }

    private static void comb(int start, int cnt){
        if(cnt==M){
            for(int i=0;i<M;i++){
                sb.append(selectedNums[i]+" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i=start;i<N;i++){
            if(nums[i]!=before){
                before = nums[i];
                selectedNums[cnt] = nums[i];
                comb(i+1, cnt+1);
            }
        }
    }
}
