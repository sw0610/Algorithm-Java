package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2_2750_수정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List nums = new ArrayList<>();

        for(int i=0;i<N;i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nums);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            sb.append(nums.get(i)+"\n");
        }

        System.out.println(sb);


    }

}
