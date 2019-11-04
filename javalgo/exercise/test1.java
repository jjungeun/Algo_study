import java.util.*;
import java.io.*;

class test1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.valueOf(br.readLine());
        int p = Integer.valueOf(br.readLine());
        int[] n = new int[p];

        for(int i=0;i<p;i++){
            n[i] = Integer.valueOf(br.readLine());
        }
        
        int[] ans = new test1().solution(c, p, n);
        for(int a:ans){
            System.out.println(a);
        }
    }

    public ArrayList<Integer> mix(ArrayList<Integer> card, int n){
        ArrayList<Integer> up = new ArrayList<Integer>();
        ArrayList<Integer> down = new ArrayList<Integer>();
        
        for(int i=n;i<card.size()-n;i++){
            up.add(card.get(i));
        }
        card.removeAll(up);
        down = card;
        if(up.size() > 2*n){
            up = mix(up,n);
        }
        card = up;
        card.addAll(down);
        return card;
    }
    
    public int[] solution(int c, int p, int[] n){
        int[] answer = new int[5];
        ArrayList<Integer> card = new ArrayList<Integer>();
        for(int i =0; i<c;i++){
            card.add(i+1);
        }

        for(int i=0;i<n.length;i++){
            card=mix(card, n[i]);
        }

        for(int i=0;i<answer.length;i++){
            answer[i] = card.get(i);
        }
        return answer;
    }
}
