import java.util.*;
import java.io.*;

public class test2 {

	public static void main(String[] args) throws Exception {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<String> numbers = new ArrayList<>();
            while(st.hasMoreTokens()){
                numbers.add(st.nextToken());
            }

            // 예외처리
            boolean threeContain = false;
            Iterator<String> iter = numbers.iterator();
            while(iter.hasNext()){
                String tmp = iter.next();
                threeContain = tmp.length() == 3 ? true : threeContain;
                if(Long.valueOf(tmp)<=0 || tmp.length() > 3){
                    throw new Exception();
                }
            }
            if(threeContain && numbers.size() > 6){
                throw new Exception();
            } else if(numbers.size() > 9){
                throw new Exception();
            }

            String ans = solution(numbers);
            System.out.println(ans);
        } catch( Exception e ) {
            System.out.println("-1");
        }
    }

    static boolean findMax(String a, String b) {
        return a.length() == b.length() ? Long.valueOf(a) <= Long.valueOf(b)
            : Long.valueOf(a + b) <= Long.valueOf(b + a);
    }
    
    static ArrayList<String> quickSort(ArrayList<String> num) {
        int len = num.size();
        ArrayList<String> arr;
        if (len <= 1) {
            return num;
        } else {
            String now = num.get(0);
            ArrayList<String> greater = new ArrayList<>();
            ArrayList<String> less = new ArrayList<>();
            for (int i = 1; i < len; i++) {
                if (findMax(now, num.get(i))) {
                    greater.add(num.get(i));
                } else {
                    less.add(num.get(i));
                }
            }

            arr = quickSort(greater);
            arr.add(now);
            arr.addAll(quickSort(less));
            return arr;
        }
    }

    static String solution(ArrayList<String> numbers){
        long ans = 0;
        String maxstr = "";
        String minstr = "";
        numbers = quickSort(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            maxstr += numbers.get(i);
            minstr += numbers.get(numbers.size()-i-1);
        }

        ans = Long.valueOf(maxstr) + Long.valueOf(minstr);
        return Long.toString(ans);
    }
}
