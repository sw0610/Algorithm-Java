package Programmers.Lv3;

import java.util.*;

class 베스트앨범 {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Map<String, HashMap<Integer, Integer>>songs = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        for(int i=0;i<genres.length;i++){

            if(!songs.containsKey(genres[i])){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                songs.put(genres[i], map);
                total.put(genres[i], plays[i]);
            }
            else{
                songs.get(genres[i]).put(i, plays[i]);
                total.put(genres[i], total.get(genres[i])+plays[i]);
            }
        }
        
        List<String> totalKeys = new ArrayList<>(total.keySet());        
        Collections.sort(totalKeys, (s1, s2)->total.get(s2)-total.get(s1));
        
        for(String key:totalKeys){
            HashMap<Integer, Integer> map = songs.get(key);
            List<Integer> songKeys = new ArrayList<>(map.keySet());
            Collections.sort(songKeys, (s1, s2)->map.get(s2)-map.get(s1));
            int idx = 0;
            answer.add(songKeys.get(0));
            if(songKeys.size()>1){
                answer.add(songKeys.get(1));
            }
        }
        return answer;
    }
}