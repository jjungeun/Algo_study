package recursion;

import java.util.Scanner;

public class EuclidGCD {
	
	static int gcd(int x,int y) {
		
		//재귀메서드 호출한 경우
		if(y==0) {
			return x;
		}else {
			System.out.println(x%y);
			return gcd(y,x%y);
		}
		
		//재귀 메서드 호출하지 않은 경우
/*		int n=y;
		int tmp;
		for(int i=x;;) {
			if(n==0) {
				return i;
			}
			else {
				i=i%n;
				
				tmp = i;
				i = n;
				n= tmp;
			}
		}*/
		
		//재귀 메서드 호출하지 않은 경우 - 효율적으로!
/*		while(y!=0) {
			int temp = y;
			y = x%y;
			x = temp;
		}
		return x;*/
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수의 최대공약수를 구한다.");
		System.out.print("정수를 입력하세요 : ");
		int x = sc.nextInt();
		System.out.print("정수를 입력하세요 : ");
		int y = sc.nextInt();
		System.out.println("최대 공약수는 "+gcd(x, y));
	}

}
