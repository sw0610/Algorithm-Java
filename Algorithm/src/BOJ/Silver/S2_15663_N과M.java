package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2_15663_N과M {
    static int N, M;
    static int[] nums, selectedNums;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        isSelected = new boolean[N];
        selectedNums = new int[M];
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int cnt){
        if(cnt==M){
            for(int i=0;i<M;i++){
                sb.append(selectedNums[i]+" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i=0;i<N;i++){
            if(!isSelected[i] && before!=nums[i]){
                selectedNums[cnt] = nums[i];
                isSelected[i] = true;
                before = nums[i];
                perm(cnt+1);
                isSelected[i]=false;
            }

        }

    }
}
