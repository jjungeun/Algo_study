package javalgo.recursion;

import java.util.Scanner;

// 하노이의 탑을 비재귀적으로 +++어려움
public class HanoiN {
	
	static void move(int no, int x,int y) {
		int[] xstk = new int[100];
		int[] sstk = new int[100];
		int[] ystk = new int[100];
		int ptr = 0;
		int sw = 0;
		
		while(true) {
			if(sw==0 && no>1) {
				xstk[ptr] = x;
				ystk[ptr] = y;
				sstk[ptr] = sw;
				ptr++;
				no--;
				y = 6-x-y;
				continue;
			}
			System.out.println("원반["+no+"]을"+x+"기둥에서 "+y+"기둥으로 옮김");
			if(sw==1 && no>1) {
				xstk[ptr] = x;
				ystk[ptr] = y; 
				sstk[ptr] = sw;
				ptr++;
				no--;
				x = 6 - x - y;
				if (++sw == 2)
					sw = 0;
				continue;
			}
			do {
				if(ptr-- == 0)
					return;
				x = xstk[ptr];
				y = ystk[ptr];
				sw = sstk[ptr]+1;
				no++;
			}while(sw==2);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원반 개수 : ");
		int no = sc.nextInt();
		move(no,1,3);
	}

}
