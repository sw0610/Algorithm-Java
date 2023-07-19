package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S4_10825_국영수 {

    static class Student{

        String name;
        int k;
        int e;
        int m;

        Student(String name, int k, int e, int m){
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        Comparator<Student> comparator = new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2){
                if(s1.k==s2.k){
                    if(s1.e==s2.e){
                        if(s1.m==s2.m){
                            return s1.name.compareTo(s2.name);
                        }
                        return s2.m-s1.m;
                    }
                    return s1.e-s2.e;
                }
                return s2.k-s1.k;
            }
        };

        Arrays.sort(students, comparator);

        for(int i=0;i<N;i++){
            sb.append(students[i].name+"\n");
        }

        System.out.println(sb);
    }
}
