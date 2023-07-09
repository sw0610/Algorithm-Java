package Programmers.Lv2;

import java.util.*;

class 튜플 {
    public int[] solution(String s) {

        String[] tuples = s.split("},");
        String[] nums = new String[tuples.length];
        for(int i=0;i<tuples.length;i++){

            tuples[i] = tuples[i].replace("{","");
            tuples[i] = tuples[i].replace("}","");
            tuples[i] = tuples[i].replace(","," ");
            // nums.add(tuples[i]);
            nums[i] = tuples[i];
        }
        Arrays.sort(nums, (a, b)->{return a.length()-b.length();});

        Set<String> set = new HashSet<>();
        int[] answer = new int[nums.length];
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            String[] num = nums[i].split(" ");
            for(String n : num){
                if(set.add(n)){
                    answer[idx++] = Integer.parseInt(n);
                }
            }
        }


        return answer;
    }
}