package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class S5_1427_소트인사이드 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();

        String[] arr = N.split("");

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        System.out.println(sb);


    }
}
