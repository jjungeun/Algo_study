package recursion;

import java.util.Scanner;

public class Hanoi {
	
	/* no : 원반 개수
	 * x : 시작 기둥 번호
	 * y : 목표 기둥 번호  */
	static void move(int no, int x,int y) {
		if(no>1)
			move(no-1,x,6-x-y);
		
		System.out.println("원반["+no+"]을"+x+"기둥에서 "+y+"기둥으로 옮김");
		
		if(no>1)
			move(no-1,6-x-y,y);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원반 개수 : ");
		int no = sc.nextInt();
		move(no,1,3);
	}

}
