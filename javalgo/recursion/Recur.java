package javalgo.recursion;

import java.util.Scanner;

public class Recur {

	static void recur(int n) {
		if(n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
		
		// 꼬리 재귀 제거
/*		if(n>0) {
			recur(n-1);
			System.out.println(n);
			n = n-2;
		}*/
		
		// 재귀 알고리즘의 비재귀적 표현
/*		IntStack s = new IntStack(n);
		
		while(true) {
			if(n>0) {
				s.push(n);
				n = n-1;
				continue;
			}
			if(s.isEmpty() != true) {
				n = s.pop();
				System.out.println(n);
				n = n-2;
				continue;
			}
			break;
		}*/
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int n= sc.nextInt();
		recur(n);
	}
}
