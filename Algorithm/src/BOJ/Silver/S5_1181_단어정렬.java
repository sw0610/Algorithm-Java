package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S5_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for(int i=0;i<N;i++){
            words[i] = br.readLine();
        }


        Arrays.sort(words, (o1, o2)->{
            if(o1.length()==o2.length()){
                return o1.compareTo(o2);

            }
            return o1.length()-o2.length();
        });

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]+"\n");

        for(int i=1;i<N;i++){
            if(!words[i].equals(words[i-1])){
                sb.append(words[i]+"\n");
            }
        }
        System.out.println(sb);

    }
}
